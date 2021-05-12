package org.graduation.knowledge.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author huyuanxin
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("编排传输数据内的entity")
public class Entity {

    /**
     * id
     */
    @ApiModelProperty("id")
    String id;

    /**
     * 实体名
     */
    @ApiModelProperty("实体名")
    String entityName;

    /**
     * 实体类型
     */
    @ApiModelProperty("实体类型")
    String entityType;

}
