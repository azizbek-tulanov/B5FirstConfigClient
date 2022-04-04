package com.example.b5firstconfigclient.components;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component
public class Properties {
    @Value("${secretkey.firstMicroService}")
    private String firstMicroService;

    @Value("${secretkey.secondMicroService}")
    private String secondMicroService;

    public Properties() {
    }

    public Properties(String firstMicroService, String secondMicroService) {
        this.firstMicroService = firstMicroService;
        this.secondMicroService = secondMicroService;
    }

    public String getFirstMicroService() {
        return firstMicroService;
    }

    public void setFirstMicroService(String firstMicroService) {
        this.firstMicroService = firstMicroService;
    }

    public String getSecondMicroService() {
        return secondMicroService;
    }

    public void setSecondMicroService(String secondMicroService) {
        this.secondMicroService = secondMicroService;
    }
}
