package com.teluschallenge.mapping.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;

//import com.google.common.base.Predicate;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;
import springfox.documentation.service.Contact;


@EnableSwagger2
@Configuration
public class SwaggerConfig {
	
	@Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.teluschallenge.mapping"))
                .paths(regex("/api.*"))
                .build()
                .apiInfo(metaInfo());
    }

    private ApiInfo metaInfo() {

        ApiInfo apiInfo = new ApiInfo(
                "Spring Boot One-to-One Mapping Swagger documentation.",
                "Spring Boot One-to-One Mapping APIs.",
                "1.0",
                "Terms of Service",
                new Contact("Gopinath Swaminathan", "http://teluschallenge.test",
                        "gopinathswaminadane@gmail.com"),
                "Swagger 2.6.1",
                "http://localhost:9091/gopinath-ui.html"
        );

        return apiInfo;
    }

}
