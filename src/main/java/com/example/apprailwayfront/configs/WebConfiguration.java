package com.example.apprailwayfront.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfiguration implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(
                        "/css/**",
                        "/font/**",
                        "/img/**",
                        "/js/**",
                        "/scss/**",
                        "/vendor/**",
                        "/htmls/**"
                        )
                .addResourceLocations(
                        "classpath:/templates/css/",
                        "classpath:/templates/font/",
                        "classpath:/templates/img/",
                        "classpath:/templates/js/",
                        "classpath:/templates/scss/",
                        "classpath:/templates/vendor/",
                        "classpath:/templates/htmls/"
                        );
    }
}