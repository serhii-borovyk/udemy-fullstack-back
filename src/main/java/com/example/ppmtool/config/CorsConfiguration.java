package com.example.ppmtool.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration implements WebMvcConfigurer {

    private static final String PATH_PATTERN = "/**";
    private static final String[] METHODS = {"GET", "POST", "PUT", "DELETE"};
    private static final String ORIGINS = "*";
    private static final String HEADERS = "*";

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        configureCors(registry);
    }

    private void configureCors(CorsRegistry registry) {
        registry.addMapping(PATH_PATTERN)
                .allowedMethods(METHODS)
                .allowedOrigins(ORIGINS)
                .allowedHeaders(HEADERS);
    }
}

