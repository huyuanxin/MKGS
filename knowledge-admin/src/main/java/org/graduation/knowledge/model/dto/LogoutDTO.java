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
@ApiModel("登出使用的输入体")
public class LogoutDTO {

    /**
     * 登出标识
     */
    @ApiModelProperty("登出标识")
    String logoutSign;

}
