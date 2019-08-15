package com.github.rudylucky.scd.controller;

import com.github.rudylucky.scd.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    private ConsumerService consumerService;

    @Autowired
    public ConsumerController(ConsumerService consumerService) {
        this.consumerService = consumerService;
    }

    @GetMapping("/ribbon-consumer")
    public String helloConsumer() {
        return consumerService.helloService();
    }

}
