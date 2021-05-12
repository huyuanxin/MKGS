package org.graduation.knowledge.common.util;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

/**
 * @author huyuanxin
 */
public class SerialVersionUIDTest {

    @Test
    public void generator(){
        BigDecimal xor = new BigDecimal(1720901006L ^ 17209010031L ^ 17209060168L ^ 17209120396L);
        BigDecimal and = new BigDecimal(1720901006L & 17209010031L & 17209060168L & 17209120396L);
        BigDecimal[] bigDecimal2 = xor.divideAndRemainder(and);
        System.out.println(bigDecimal2[0].toString()+bigDecimal2[1].toString());
    }
}
