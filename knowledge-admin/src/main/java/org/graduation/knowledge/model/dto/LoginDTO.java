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
@ApiModel("登录使用的输入体")
public class LoginDTO {

    /**
     * 登录用户名
     */
    @ApiModelProperty("登录用户名")
    String loginName;

    /**
     * 登录的密码
     */
    @ApiModelProperty("登录的密码")
    String loginPassword;

}
