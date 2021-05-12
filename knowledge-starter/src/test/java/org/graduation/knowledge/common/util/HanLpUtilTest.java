package org.graduation.knowledge.common.util;

import org.graduation.knowledge.util.HanLpUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @author huyuanxin
 */
@SpringBootTest
@ExtendWith(SpringExtension.class)
class HanLpUtilTest {

    @Test
    void doHanLpApi() {
        HanLpUtil.doHanLpApi("心脏病怎么治").forEach(System.out::println);
    }
}