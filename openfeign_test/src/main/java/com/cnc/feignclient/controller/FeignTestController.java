package com.cnc.feignclient.controller;


import com.cnc.feignclient.feign.client.StoreClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/feign")
public class FeignTestController {

    @Autowired
    StoreClient client;

    @GetMapping(path = "/ping_path")
    public String pingForPathServer() {
        String path = client.getPath1();
        if (path == null) {
            return "cannot reach...";
        }
        return path;
    }
}
