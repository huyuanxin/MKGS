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
public class Drug implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId("id")
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 药品名
     */
    @TableField("name")
    @ApiModelProperty(value = "药品名")
    private String name;

}
