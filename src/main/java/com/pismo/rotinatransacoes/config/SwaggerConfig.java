package com.pismo.rotinatransacoes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.any;
import static springfox.documentation.builders.RequestHandlerSelectors.basePackage;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getApiInfo())
                .select()
                .apis(basePackage("com.pismo.rotinatransacoes"))
                .paths(any())
                .build()
                .useDefaultResponseMessages(false);
    }

    protected ApiInfo getApiInfo() {
        return new ApiInfoBuilder()
                .title("Rotina de Pagamento")
                .description("Api para simulação de rotinas de transações.")
                .version("1.0")
                .build();
    }
}
