package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.paths.RelativePathProvider;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.ServletContext;

/**
 * @author bruce
 * @date 2020/11/19 21:18
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Autowired
    private ServletContext servletContext;

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(true)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.demo.controllers"))
                .paths(PathSelectors.any())
                .build()
                .pathProvider(new RelativePathProvider(servletContext) {
                    @Override
                    public String getApplicationBasePath() {
                        return "/";
                    }
                });
    }
}

