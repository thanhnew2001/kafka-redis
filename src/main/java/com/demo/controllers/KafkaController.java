package com.demo.controllers;


import com.demo.engine.Producer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {


    private static final Logger logger = LoggerFactory.getLogger(KafkaController.class);
    private static final String TOPIC = "users";

//    @Autowired
//    private CityRepository cityRepository;

//    @Autowired
//    private KafkaTemplate<String, String> kafkaTemplate; //producers

    @Autowired
    private Producer producer;


    @PostMapping(value = "/publish")
    public String sendMessageToKafkaTopic(@RequestParam("message") String message) {
        logger.info(String.format("#### -> Producing message -> %s", message));

        //this.kafkaTemplate.send(TOPIC, message);

        this.producer.sendMessage(message);

        //this.cityRepository.save(new City(message));
        return "Success";

    }

    @GetMapping(value = "/hello")
    public void hello() {
        System.out.println("Hello");
    }

}
