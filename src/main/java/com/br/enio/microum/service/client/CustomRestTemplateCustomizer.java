package com.br.enio.microum.service.client;

import com.br.enio.microum.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

public class CustomRestTemplateCustomizer implements RestTemplateCustomizer, ClientHttpRequestInterceptor {

    @Autowired
    private TokenService service;

    @Override
    public void customize(RestTemplate restTemplate) {
           restTemplate.getInterceptors().add(this::intercept);
    }

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        var token = service.getAuthorizationToken();
        request.getHeaders().add(HttpHeaders.AUTHORIZATION, token);
        return execution.execute(request, body);
    }
}
