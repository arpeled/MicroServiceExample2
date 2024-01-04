package com.example.micro2.rabbit;

import lombok.extern.slf4j.Slf4j;
import org.acum.shared.MyMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class RabbitMessageListener {
    @Autowired
    private   RestTemplate restTemplate;
    @RabbitListener(queues = "acum.queue")
    public void handleMessage(MyMessage message) throws InterruptedException {
       log.info("Received message: " + message.getContent());

       try {
           restTemplate.getForEntity("http://localhost:8080/micro1/event?msg=event sent from micro 2", String.class);
       }
       catch (Exception e)
       {
           log.info("failed to send event back to micro 1");
           e.printStackTrace();
       }

        // Process the message here as needed
        log.info("sent event back to micro 1");
    }
}
