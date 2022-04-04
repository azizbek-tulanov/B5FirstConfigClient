package com.example.b5firstconfigclient;

import com.example.b5firstconfigclient.components.Properties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
public class B5FirstConfigClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(B5FirstConfigClientApplication.class, args);
    }

}
