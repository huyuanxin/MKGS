package org.graduation.knowledge.model;

import lombok.Getter;

/**
 * @author huyuanxin
 */
@Getter
public enum BodyParts {

    /**
     * 头部
     */
    Head("头部"),

    /**
     * 肩颈部
     */
    ShoulderAndNeck("肩颈部"),

    /**
     * 胸部
     */
    Chest("胸部"),

    /**
     * 腹部
     */
    Abdomen("腹部"),

    /**
     * 背部
     */
    Back("背部"),

    /**
     * 臀部
     */
    Buttocks("臀部"),

    /**
     * 双上肢
     */
    UpperLimbs("双上肢"),

    /**
     * 生殖器
     */
    Genitals("生殖器"),

    /**
     * 双下肢
     */
    LowerLimbs("双下肢");

    /**
     * 中文名称
     */
    private final String chineseName;

    BodyParts(String chineseName) {
        this.chineseName = chineseName;
    }

}
