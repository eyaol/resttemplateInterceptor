package com.br.enio.microum.config;

import com.br.enio.microum.service.client.CustomRestTemplateCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Bean("basicRestTemplate")
    public RestTemplate basicRestTemplate() {
        return new RestTemplate();
    }
    @Bean
    public CustomRestTemplateCustomizer customRestTemplateCustomizer() {
        return new CustomRestTemplateCustomizer();
    }
    @Bean
    @Primary
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        customRestTemplateCustomizer().customize(restTemplate);
        return restTemplate;
    }

}
