package com.example.demo.controller;

import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PutController {

    @PutMapping
    public void put(){

    }

    @PatchMapping
    public void patch(){

    }

}
