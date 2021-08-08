package com.cnc.testing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Service
public class MainController {

    @Autowired
    private TestService service;

    private static final String NAME = "Tony";

    @RequestMapping("/testA")
    public String testA() {
        System.out.println(this);
        System.out.println(NAME);
        return service.getTestString();
    }

    @RequestMapping("/testB")
    public final String testB() {
        System.out.println("hello world");
        System.out.println(NAME);
        System.out.println(this);
        return service.getTestString();
    }

}
