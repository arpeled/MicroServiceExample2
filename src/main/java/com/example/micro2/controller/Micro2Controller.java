package com.example.micro1.controller;
import com.example.micro1.service.Micro1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("micro1")
public class Micro1Controller {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    Micro1Service service;

    @RequestMapping("name")
    public String getMicroserviceName()
    {
        String micro2Response = restTemplate.postForObject("http://localhost:8081/micro2/name", null, String.class);
        String micro3Response = restTemplate.postForObject("http://localhost:8082/micro3/name", null, String.class);
        return service.getMicroserviceName() + " : " + micro2Response + " : " + micro3Response;
    }
}