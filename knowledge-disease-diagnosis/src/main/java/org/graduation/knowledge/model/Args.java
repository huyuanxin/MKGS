package org.graduation.knowledge.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

/**
 * @author huyuanxin
 */
@ApiModel("参数列表")
@Getter
public enum Args {
    /**
     * 年龄
     */
    @ApiModelProperty("Age")
    Age("年龄"),

    /**
     * 症状
     */
    @ApiModelProperty("症状")
    Symptom("症状");

    private final String chineseName;

    Args(String chineseName) {
        this.chineseName = chineseName;
    }

}
