package com.br.enio.microum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TokenService {

    @Qualifier("basicRestTemplate")
    @Autowired
    private RestTemplate basicRestTemplate;

    @Value("${auth.url}")
    private String authUrl;

    @Cacheable(value = "sts_cache")
    public String getAuthorizationToken() {
        return basicRestTemplate.getForObject(authUrl, String.class);
    }

}
