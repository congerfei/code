package com.xl.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {

    @Autowired
    KafkaTemplate kafkaTemplate;

    @GetMapping("/send/{messge}")
    public String send(@PathVariable String messge) {
        System.out.println(kafkaTemplate);
        kafkaTemplate.send("topic1", "topci1:" + messge);
        kafkaTemplate.send("topic2", "topci2:" + messge);
        return messge;
    }

    @KafkaListener(topics = {"topic1", "topic2"})
    public void listen1(String data) {
        System.out.println(data);
    }

}
