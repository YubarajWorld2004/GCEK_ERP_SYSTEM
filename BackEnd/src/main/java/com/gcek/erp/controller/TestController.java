package com.gcek.erp.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/test")
@CrossOrigin(origins = "*")
public class TestController {

    @GetMapping("/hello")
    public String hello() {
        return "GCEK ERP Backend is Running!";
    }

    @GetMapping("/status")
    public String status() {
        return "{\"status\": \"running\", \"timestamp\": \"" + System.currentTimeMillis() + "\"}";
    }
}
