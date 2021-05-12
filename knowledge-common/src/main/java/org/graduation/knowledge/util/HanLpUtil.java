package org.graduation.knowledge.util;

import com.alibaba.fastjson.JSON;
import com.hankcs.hanlp.restful.HanLPClient;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.*;

/**
 * @author huyuanxin
 */
@Component
public class HanLpUtil {

    @Value("${hanLp.url}")
    private String urlForStatic;
    @Value("${hanLp.token.v1}")
    private String tokenV1xForStatic;
    @Value("${hanLp.token.v2}")
    private String tokenV2xForStatic;

    private static String url = null;
    private static String tokenV1x = null;
    private static String tokenV2x = null;

    @PostConstruct
    public void init() {
        url = urlForStatic;
        tokenV1x = tokenV1xForStatic;
        tokenV2x = tokenV2xForStatic;
    }

    /**
     * HanLp2.x分词方法
     *
     * @param question 问句
     * @return 分词结果
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public static List<String> doHanLpApi(String question) {
        HanLPClient client = new HanLPClient("https://www.hanlp.com/api", tokenV2x);
        Optional<Map<String, List>> response = Optional.empty();
        try {
            response = Optional.ofNullable(client.parse(question));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response
                .map(it -> it.get("tok/coarse"))
                .filter(it -> !it.isEmpty())
                .map(it -> (List<String>) it.get(0))
                .orElse(new ArrayList<>());
    }

    /**
     * HanLp 1.x的分词方法
     *
     * @param input 需要分词的句子
     * @return 分词结果
     * @deprecated
     */
    @SuppressWarnings({"unchecked"})
    public static List<String> getWords(String input) {
        //所有参数
        Map<String, Object> params = new HashMap<>(1);
        params.put("text", input);
        // 执行api
        String result = doHanLpApi(tokenV1x, url, params);

        Map<String, Object> map = (Map<String, Object>) JSON.parse(result);
        List<String> list = new ArrayList<>();
        if (null != map) {
            List<Map<String, String>> dataMap = (List<Map<String, String>>) map.get("data");
            for (Map<String, String> data : dataMap) {
                list.add(data.get("word"));
            }
        }
        return list;
    }

    /**
     * 请求HanLp分词v1.0
     *
     * @param token  token
     * @param url    请求url
     * @param params 参数
     * @return http的返回
     * @deprecated
     */
    public static String doHanLpApi(String token, String url, Map<String, Object> params) {
        // 创建Httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        try {
            // 创建Http Post请求
            HttpPost httpPost = new HttpPost(url);
            //添加header请求头，token请放在header里
            httpPost.setHeader("token", token);
            // 创建参数列表
            List<NameValuePair> paramList = new ArrayList<>();
            if (params != null) {
                for (String key : params.keySet()) {
                    //所有参数依次放在paramList中
                    paramList.add(new BasicNameValuePair(key, (String) params.get(key)));
                }
                //模拟表单
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList, "utf-8");
                httpPost.setEntity(entity);
            }
            // 执行http请求
            response = httpClient.execute(httpPost);
            return EntityUtils.toString(response.getEntity(), "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

}
