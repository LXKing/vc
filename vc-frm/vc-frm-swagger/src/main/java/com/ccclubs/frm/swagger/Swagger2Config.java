package com.ccclubs.frm.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo()).forCodeGeneration(true)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ccclubs"))
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("车机中心 RESTful APIs")
                .description("车机中心")
                .termsOfServiceUrl("")
                .contact(new Contact("Vehicle Center", "", "xugang@ccclubs.com"))
                .version("1.0.0")
                .build();
    }
    @Bean
    UiConfiguration uiConfig() {
      return new UiConfiguration(
          "validatorUrl",// url
          "list",       // docExpansion          => none | list
          "alpha",      // apiSorter             => alpha
          "schema",     // defaultModelRendering => schema
          UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS,
          true,        // enableJsonEditor      => true | false
          true,         // showRequestHeaders    => true | false
          60000L);      // requestTimeout => in milliseconds, defaults to null (uses jquery xh timeout)
    }
}
