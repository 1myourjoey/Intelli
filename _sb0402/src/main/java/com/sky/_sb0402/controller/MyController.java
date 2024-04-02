package com.sky._sb0402.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class MyController {

    @GetMapping("/")
    public  String main(){
        return "root";
    }
}
