package com.cnc.myboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Example {
    @RequestMapping("/")
    String index() {
        return "Hello World!";
    }
}
