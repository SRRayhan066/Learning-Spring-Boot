package com.example.springBootApplication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstAPI {
    @GetMapping("hello")
    public String sayHello(){
        return "Hey there!!";
    }
}
