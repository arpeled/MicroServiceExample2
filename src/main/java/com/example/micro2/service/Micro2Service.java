package com.example.micro2.service;

import com.example.micro2.dao.Micro2Dao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class Micro2Service {

    @Autowired
    Micro2Dao dao;

    public String getMicroserviceName()
    {
        return dao.getMicroserviceName();
    }
    private static final String EXCHANGE_NAME = "topic_logs";


}