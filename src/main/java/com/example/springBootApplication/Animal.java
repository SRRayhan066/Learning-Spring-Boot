package com.example.springBootApplication;

import org.springframework.stereotype.Component;

@Component
public class Animal {
    public String tellName(String name){
        String text = "Hey!! My name is "+name;
        return text;
    }
}
