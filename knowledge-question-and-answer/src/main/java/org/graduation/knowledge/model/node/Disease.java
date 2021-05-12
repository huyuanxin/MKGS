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
public class Disease implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId("id")
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 疾病名称
     */
    @TableField("`name`")
    @ApiModelProperty(value = "疾病名称")
    private String name;

    /**
     * 疾病详情
     */
    @TableField("`desc`")
    @ApiModelProperty(value = "疾病详情")
    private String desc;

    /**
     * 疾病预防措施
     */
    @TableField("prevent")
    @ApiModelProperty(value = "疾病预防措施")
    private String prevent;

    /**
     * 疾病原因
     */
    @TableField("cause")
    @ApiModelProperty(value = "疾病原因")
    private String cause;

    /**
     * 疾病易感人群
     */
    @TableField("easy_get")
    @ApiModelProperty(value = "疾病易感人群")
    private String easyGet;

    /**
     * 疾病治愈所需时间
     */
    @TableField("cure_lasttime")
    @ApiModelProperty(value = "疾病治愈所需时间")
    private String cureLastTime;

    /**
     * 治疗科室
     */
    @TableField("cure_department")
    @ApiModelProperty(value = "治疗科室")
    private String cureDepartment;

    /**
     * 疾病治疗方法
     */
    @TableField("cure_way")
    @ApiModelProperty(value = "疾病治疗方法")
    private String cureWay;

    /**
     * 疾病治愈率
     */
    @TableField("cured_prob")
    @ApiModelProperty(value = "疾病治愈率")
    private String curedProb;

    /**
     * 由于数据库中的cureWay是以数组的形式存储的，因此该函数将其转换为空格间隔的字符串
     *
     * @return cureWay
     */
    public String getCureWayFormat() {
        return formatString(this.cureWay);
    }

    /**
     * 由于数据库中的cureDepartment是以数组的形式存储的，因此该函数将其转换为空格间隔的字符串
     *
     * @return cureDepartment
     */
    public String getCureDepartmentFormat() {
        return formatString(this.cureDepartment);
    }

    /**
     * 去除字符串中的 "[","]","""
     *
     * @param key 需要转换的字符串
     * @return 转换后的字符串
     */
    public String formatString(String key) {
        return key.replaceAll("\\[", "").replaceAll("]", "").replaceAll("\"", "");
    }
}
