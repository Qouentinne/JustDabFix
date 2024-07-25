package com.training.justdab.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    public WelcomeController() {}

    @GetMapping("/welcome")
    @ResponseBody
    public ResponseEntity<String> welcome() {
        return ResponseEntity.ok("Welcome to Dab!");
    }
}
