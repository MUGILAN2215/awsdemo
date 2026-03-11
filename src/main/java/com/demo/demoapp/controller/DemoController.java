package com.demo.demoapp.controller;

import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class DemoController {

    // GET /api/hello
    @GetMapping("/hello")
    public String hello() {
        return "Hello da ma! AWS deployment working! 🎉";
    }

    // GET /api/status
    @GetMapping("/status")
    public Map<String, String> status() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "Running");
        response.put("message", "Spring Boot is live on AWS!");
        response.put("time", LocalDateTime.now().toString());
        return response;
    }

    // GET /api/user/{name}
    @GetMapping("/user/{name}")
    public Map<String, String> getUser(@PathVariable String name) {
        Map<String, String> response = new HashMap<>();
        response.put("name", name);
        response.put("message", "Hello " + name + "! You hit the AWS server!");
        return response;
    }

    // POST /api/echo
    @PostMapping("/echo")
    public Map<String, String> echo(@RequestBody Map<String, String> body) {
        Map<String, String> response = new HashMap<>();
        response.put("you_sent", body.toString());
        response.put("server_says", "AWS received your POST request!");
        return response;
    }

    // GET /api/health
    @GetMapping("/health")
    public Map<String, String> health() {
        Map<String, String> response = new HashMap<>();
        response.put("health", "UP");
        response.put("server", "AWS EC2");
        response.put("java", System.getProperty("java.version"));
        return response;
    }
}
