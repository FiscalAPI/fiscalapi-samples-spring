package com.fiscalapi.samples.spring.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI fiscalapiOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("FiscalApi Java Spring")
                        .description("Integración de FiscalApi con Java Spring")
                        .version("v1.0.0")
                        .contact(new Contact()
                                .name("FiscalAPI")
                                .url("https://fiscalapi.com")));
    }
}