package com.github.rudylucky.scd.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    private DiscoveryClient client;
    private Registration registration;

    @Autowired
    public HelloController(DiscoveryClient discoveryClient, Registration registration) {
        this.client = discoveryClient;
        this.registration = registration;
    }

    @GetMapping("/hello")
    public String index() {
        client.getServices().forEach(id ->
                client.getInstances(id).forEach(instance ->
                        logger.info("/hello, host:" + instance.getHost() + ", service_id:" + instance.getServiceId())));
        return "hello";
    }
}
