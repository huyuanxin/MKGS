package org.graduation.knowledge.model.node;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

import java.io.Serializable;

/**
 * @author huyuanxin
 */
@Data
@NodeEntity
@TableName("`check`")
@NoArgsConstructor
@AllArgsConstructor
public class Check implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @Id
    @TableId("ID")
    @GeneratedValue
    @ApiModelProperty("id")
    private Long id;

    /**
     * 检查名称
     */
    @TableField("name")
    @ApiModelProperty("检查名称")
    private String name;

}
