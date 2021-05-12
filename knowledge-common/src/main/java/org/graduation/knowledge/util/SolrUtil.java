package org.graduation.knowledge.util;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.request.FieldAnalysisRequest;
import org.apache.solr.client.solrj.response.AnalysisResponseBase.AnalysisPhase;
import org.apache.solr.client.solrj.response.AnalysisResponseBase.TokenInfo;
import org.apache.solr.client.solrj.response.FieldAnalysisResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

/**
 * @author huyuanxin
 */
@Component
public class SolrUtil {
    final private SolrClient solrClientForStatic;

    private static SolrClient solrClient = null;

    @PostConstruct
    void init() {
        solrClient = solrClientForStatic;
    }

    @Autowired
    public SolrUtil(SolrClient solrClient) {
        this.solrClientForStatic = solrClient;
    }

    /**
     * Http请求分词
     *
     * @param input 需要分词的句子
     * @return 句子分词后的词
     */
    public static List<String> getWord(String input) {
        Optional<JSONObject> jsonOptional = Optional.ofNullable(JSONObject.parseObject(HttpUtil.get("http://localhost:8983/solr/MyCore/analysis/field?_=1613636740673&analysis.fieldtype=text_ik&analysis.fieldvalue=" + input + "&analysis.showmatch=true&verbose_output=0&wt=json")));
        return jsonOptional
                .map(it -> it.getJSONObject("analysis").getJSONObject("field_types").getJSONObject("text_ik"))
                .map(it -> (JSONArray) it.get("index"))
                .map(it -> (JSONArray) it.get(1))
                .map(it -> {
                    List<String> wordList = new ArrayList<>();
                    it.forEach(o -> wordList.add(((JSONObject) o).getString("text")));
                    return wordList;
                })
                .orElse(new ArrayList<>());
    }

    /**
     * Solrj 支持的分词
     *
     * @param input         需要分词的句子
     * @param fieldTypeName 分词器的名称，通常为 text_ik
     * @return 句子分词后的词
     */
    public static List<String> analyse(String input, String fieldTypeName) {
        FieldAnalysisRequest request = new FieldAnalysisRequest("/analysis/field");
        request.addFieldType(fieldTypeName);
        request.setFieldValue("");
        request.setFieldValue(input);
        Optional<FieldAnalysisResponse> response = Optional.empty();
        try {
            response = Optional.ofNullable(request.process(solrClient));
        } catch (SolrServerException | IOException e) {
            e.printStackTrace();
        }
        return response
                .map(it -> it.getFieldTypeAnalysis(fieldTypeName))
                .map(it -> {
                    Iterator<AnalysisPhase> iterator = it.getIndexPhases().iterator();
                    List<String> results = new ArrayList<>();
                    if (iterator.hasNext()) {
                        AnalysisPhase analysisPhase = iterator.next();
                        List<TokenInfo> tokenInfoList = analysisPhase.getTokens();
                        tokenInfoList.forEach(info -> results.add(info.getText()));
                    }
                    return results;
                })
                .orElse(new ArrayList<>());
    }
}
