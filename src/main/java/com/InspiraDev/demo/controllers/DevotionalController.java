package com.InspiraDev.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.InspiraDev.demo.services.devotionalService;

@RestController
@RequestMapping("/api")
public class DevotionalController {

    private devotionalService devotionalService;

    public DevotionalController(devotionalService devotionalService) {
        this.devotionalService = devotionalService;
    }

    @GetMapping
    public String getDevotionalService() {
        return "oi";
    }
}
