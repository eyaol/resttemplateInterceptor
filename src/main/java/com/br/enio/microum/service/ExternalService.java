package com.br.enio.microum.service;

import com.br.enio.microum.service.client.CustomRestTemplateCustomizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ExternalService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${micro.dois.url}")
    private String microDoisUrl;

    public String chamarMicroDois() {
        var response = restTemplate.getForObject(microDoisUrl, String.class);
        return response;
    }

    public String chamarMicroDoisDois() {
        var response = restTemplate.getForObject("http://localhost:8086/conta_dois", String.class);
        return response;
    }

}
