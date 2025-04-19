package com.fiscalapi.samples.spring.config;

import com.fiscalapi.common.FiscalApiSettings;
import com.fiscalapi.services.FiscalApiClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FiscalApiConfig {

    @Value("${fiscalapi.url}")
    private String apiUrl;

    @Value("${fiscalapi.key}")
    private String apiKey;

    @Value("${fiscalapi.tenant}")
    private String tenant;

    @Value("${fiscalapi.debug:false}")
    private boolean debugMode;

    @Bean
    public FiscalApiSettings fiscalApiSettings() {
        FiscalApiSettings settings = new FiscalApiSettings();
        settings.setDebugMode(debugMode);
        settings.setApiUrl(apiUrl);
        settings.setApiKey(apiKey);
        settings.setTenant(tenant);
        return settings;
    }

    @Bean
    public FiscalApiClient fiscalApiClient(FiscalApiSettings settings) {
        return FiscalApiClient.create(settings);
    }
}