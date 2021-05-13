package com.xl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
@RunWith(SpringRunner.class)//一定要带，不然得不到很多bean
public class KafkaApplicationTest {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Test
    public void contextLoads() {

    }

    @Test
    public void test1() {
        kafkaTemplate.send("topic20" , "hello");
    }









}
