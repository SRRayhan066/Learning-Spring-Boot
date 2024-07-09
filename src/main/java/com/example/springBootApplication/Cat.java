package com.example.springBootApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Cat {

    @Autowired
    Animal animal;
    @GetMapping("/cat")
    public String tellName(){
        return animal.tellName("Tom");
    }
}
