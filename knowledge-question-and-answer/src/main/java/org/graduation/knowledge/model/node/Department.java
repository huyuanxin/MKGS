package org.graduation.knowledge.model.node;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.NodeEntity;

import java.io.Serializable;


/**
 * @author huyuanxin
 */
@Data
@NodeEntity
@NoArgsConstructor
@AllArgsConstructor
public class Department implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId("id")
    @ApiModelProperty("id")
    private Long id;

    /**
     * 科室名称
     */
    @TableField("name")
    @ApiModelProperty("科室名称")
    private String name;

}
