package com.example.b5firstconfigclient.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.Properties;

@RestController
@RefreshScope
@RequestMapping("/api/first")
public class FirstClientController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private Environment env;

    @GetMapping
    public HttpEntity<?> get() throws IOException {
        HttpHeaders headers = new HttpHeaders();
        String property = env.getProperty("secretkey.secondMicroService");
        System.out.println("Second Secret To Send : "+property);
        headers.set("secret", property);
        HttpEntity<?> entity = new HttpEntity<>(headers);
        ResponseEntity<Object> exchange = restTemplate.exchange("http://localhost:8082/api/second/allStudent", HttpMethod.GET, entity, Object.class);
        System.out.println("RES FROM SECOND : "+exchange.getBody());
        return ResponseEntity.ok(""+exchange.getBody()+ "  :  "+new Date());
    }
}
