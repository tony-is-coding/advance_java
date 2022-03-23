package com.cnc.myboot.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

//@Component
public class ArgReader {
    @Autowired
    public ArgReader(ApplicationArguments arguments) {
        boolean debug = arguments.containsOption("debug");
        System.out.println("is debug:" + debug);
    }
}
