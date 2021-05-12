package org.graduation.knowledge.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author huyuanxin
 */
@Configuration
public class SwaggerConfig {

    /**
     * 该套 API 说明，包含作者、简介、版本
     *
     * @return 配置
     */
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.OAS_30).apiInfo(
                new ApiInfoBuilder()
                        .contact(new Contact(
                                "huyuanxin",
                                "https://github.com/huyuanxin",
                                "huyuanxin1999@outlook.com"))
                        .title("知识图谱项目")
                        .description("基于知识图谱的患者疾病辅助决策")
                        .version("1.0.0")
                        .build()
        )
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .build();
    }
}
