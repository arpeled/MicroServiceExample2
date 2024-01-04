package com.example.micro2;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@EnableRabbit
@SpringBootApplication
@ComponentScan(basePackages = "com.example") // Replace with your package name
public class Micro2Application {

    public static void main(String[] args) {
        SpringApplication.run(Micro2Application.class, args);
    }

}
