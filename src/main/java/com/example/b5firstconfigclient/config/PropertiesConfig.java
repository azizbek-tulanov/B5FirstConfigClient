package com.example.b5firstconfigclient.config;

import com.example.b5firstconfigclient.components.Properties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class PropertiesConfig {

    @Bean
    public RestTemplate restTemplate(){
        return  new RestTemplate();
    }

    @Bean
    public Properties properties(){
        return new Properties();
    }
}
