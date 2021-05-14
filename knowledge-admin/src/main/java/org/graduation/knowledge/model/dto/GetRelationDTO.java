package org.graduation.knowledge.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author huyuanxin
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("获得两者关系的DTO")
public class GetRelationDTO {

    /**
     * 头节点的类型
     */
    @ApiModelProperty("头节点的类型")
    String headType;

    /**
     * 尾节点的类型
     */
    @ApiModelProperty("尾节点的类型")
    String tailType;

}
