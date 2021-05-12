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
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("编排传输数据内的relations")
public class Relation {

    /**
     * key
     */
    @ApiModelProperty("key")
    String key;

    /**
     * 关系名称
     */
    @ApiModelProperty("关系名称")
    String relationName;

}
