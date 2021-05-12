package org.graduation.knowledge.common.util;

import org.graduation.knowledge.util.SolrUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

/**
 * @author huyuanxin
 */
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class SolrUtilTest {
    @Autowired
    SolrUtil solrUtil;

    @Test
    void analyse() {
        List<String> list = SolrUtil.analyse("心脏病怎么治", "text_ik");
        list.forEach(System.out::println);
        Assertions.assertNotNull(list);
        Assertions.assertNotEquals(0, list.size());
    }

    @Test
    void getWord() {
        List<String> list = SolrUtil.getWord("心脏病怎么治");
        list.forEach(System.out::println);
        Assertions.assertNotNull(list);
        Assertions.assertNotEquals(0, list.size());
    }
}