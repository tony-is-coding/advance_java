package com.cnc.testing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@RestController
public class MyCallerController {

    @Autowired
    MainController controller;

    @RequestMapping("/caller")
    public void testCaller() {
        try {
            System.out.println("\n 开始直接调用 方法B \n");
            controller.testB();
            System.out.println("\n 完成直接调用 方法B \n");

            System.out.println("\n 开始反射调用 方法B \n");
            Method method = MainController.class.getMethod("testB");
            method.invoke(controller);
            System.out.println("\n 完成反射调用 方法B \n");
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
