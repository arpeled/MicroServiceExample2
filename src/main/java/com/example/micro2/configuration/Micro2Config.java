package com.example.micro1.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Micro1Config {

    @Bean
    public RestTemplate restTemplate()
    {
        return new RestTemplate();
    }
}