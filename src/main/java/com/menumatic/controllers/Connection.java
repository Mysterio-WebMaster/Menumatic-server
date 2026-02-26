package com.menumatic.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Connection {
    @GetMapping("/")
    public String greeting(){
        return "Initial API";
    }
}
