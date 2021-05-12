package org.graduation.knowledge.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.graduation.knowledge.model.Args;

import java.io.Serializable;

/**
 * @author huyuanxin
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("疾病诊断的输入")
public class DiagnosisDTO implements Serializable {

    private static final long serialVersionUID = 20038194189L;

    /**
     * 分配的uuid
     */
    @ApiModelProperty("分配的uuid")
    String uuid;

    /**
     * 参数名称
     */
    @ApiModelProperty("参数名称")
    Args args;

    /**
     * 参数值
     */
    @ApiModelProperty("参数值")
    String values;

}
