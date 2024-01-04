package com.example.micro2.controller;
import com.example.micro2.service.Micro2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("micro2")
public class Micro2Controller {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    Micro2Service service;

    @RequestMapping("name")
    public String getMicroserviceName()
    {
        return service.getMicroserviceName() ;
    }
}