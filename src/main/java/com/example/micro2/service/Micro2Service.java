package com.example.micro1.service;

import com.example.micro1.dao.Micro1Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class Micro1Service {

    @Autowired
    Micro1Dao dao;

    public String getMicroserviceName()
    {
        return dao.getMicroserviceName();
    }
}