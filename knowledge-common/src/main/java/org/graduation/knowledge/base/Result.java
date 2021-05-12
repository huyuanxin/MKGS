package org.graduation.knowledge.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author huyuanxin
 */
@Data
@ApiModel(value = "Result", description = "通用接口返回封装")
public class Result<T> implements Serializable {
    /**
     * 成功标志
     */
    @ApiModelProperty("成功标志")
    private boolean success;

    /**
     * 消息
     */
    @ApiModelProperty("消息")
    private String message;

    /**
     * 返回代码
     */
    @ApiModelProperty("返回代码")
    private Integer code;

    /**
     * 时间戳
     */
    @ApiModelProperty("时间戳")
    private final long timestamp = System.currentTimeMillis();

    /**
     * 结果对象
     */
    @ApiModelProperty("结果对象")
    private T result;
}
