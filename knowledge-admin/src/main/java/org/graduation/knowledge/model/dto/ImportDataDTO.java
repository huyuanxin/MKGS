package org.graduation.knowledge.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.graduation.knowledge.model.Entity;
import org.graduation.knowledge.model.Relation;

import java.util.List;

/**
 * @author huyuanxin
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("保存关系的输入")
public class ImportDataDTO {

    /**
     * 实体列表
     */
    @ApiModelProperty("实体列表")
    List<Entity> entities;

    /**
     * 实体的关系
     */
    @ApiModelProperty("实体的关系")
    List<Relation> relations;

}
