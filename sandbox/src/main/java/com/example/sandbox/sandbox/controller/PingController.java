package com.example.sandbox.sandbox.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {

    Logger logger = LoggerFactory.getLogger(PingController.class);

    @GetMapping("/ping")
    public String ping() {
        logger.info("Incoming request to /ping endpoint...");
        return "{\"message\": \"pong\"}";
    }
}