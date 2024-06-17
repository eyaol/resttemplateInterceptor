package com.br.enio.microum.controller;

import com.br.enio.microum.service.ExternalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Autowired
    private ExternalService externalService;

    @GetMapping("/api/cache")
    public ResponseEntity<Object> testHeaderCaching() {
        var response = externalService.chamarMicroDois();
        externalService.chamarMicroDoisDois();
        return ResponseEntity.ok(response);
    }
    
}
