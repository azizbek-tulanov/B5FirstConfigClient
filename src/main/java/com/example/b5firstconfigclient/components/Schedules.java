package com.example.b5firstconfigclient.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Properties;

@Component
@EnableScheduling
public class Schedules {

    private final String URL_ACTUATOR_REFRESH="http://localhost:8081/actuator/refresh";

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private Environment env;

    @Scheduled(fixedDelay = 30000,initialDelay = 30000)
    public void refreshActuator(){
       try {
           HttpHeaders headers = new HttpHeaders();
           headers.set("Content-Type", "application/json");
           HttpEntity<?> entity = new HttpEntity<>(headers);
           ResponseEntity<Object[]> exchange = restTemplate.exchange(URL_ACTUATOR_REFRESH, HttpMethod.POST, entity, Object[].class);
           System.out.println("Second Secret Scheduled : "+ env.getProperty("secretkey.secondMicroService"));
           System.out.println(Arrays.toString(exchange.getBody()));


       }catch (Exception e){
           e.printStackTrace();
       }
    }

}
