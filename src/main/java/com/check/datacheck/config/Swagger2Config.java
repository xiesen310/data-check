package com.check.datacheck.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author 谢森
 * @Description Swagger2Config
 * @className com.check.datacheck.config.Swagger2Config
 * @Email xiesen@zork.com.cn
 * @Date 2019/12/5 16:50 星期四
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    /**
     * 集成 swagger2 如果出现问题，添加此注解 @Primary
     * @return
     */
    @Bean
    @Primary
    public Docket createRestApi() {

        return new Docket(DocumentationType.SWAGGER_2).
                apiInfo(apiinfo2()).
                select()
                // 包路径
                .apis(RequestHandlerSelectors.basePackage("com.check.datacheck.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiinfo2() {
        return new ApiInfoBuilder()
                //页面标题
                .title("数据校验")
                //页面描述
                .description("API描述")
                //版本号
                .version("1.0")
                .build();
    }

}
