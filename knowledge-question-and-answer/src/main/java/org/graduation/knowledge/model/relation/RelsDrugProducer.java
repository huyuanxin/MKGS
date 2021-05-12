package org.graduation.knowledge.model.relation;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.graduation.knowledge.model.node.Drug;
import org.graduation.knowledge.model.node.Producer;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

import java.io.Serializable;
import java.util.List;

/**
 * @author huyuanxin
 */
@Data
@RelationshipEntity
@ApiModel(value = "实体类")
@TableName("rels_drug_producer")
public class RelsDrugProducer implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId("id")
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * startNode
     */
    @TableField("start_node")
    @ApiModelProperty(value = "startNode")
    private String startNode;

    /**
     * endNode
     */
    @TableField("end_node")
    @ApiModelProperty(value = "endNode")
    private String endNode;

    /**
     * relType
     */
    @TableField("rel_type")
    @ApiModelProperty(value = "relType")
    private String relType;

    /**
     * relName
     */
    @TableField("rel_name")
    @ApiModelProperty(value = "relName")
    private String relName;

    @StartNode
    @TableField(exist = false)
    Drug drug;

    @EndNode
    @TableField(exist = false)
    List<Producer> producers;
}
