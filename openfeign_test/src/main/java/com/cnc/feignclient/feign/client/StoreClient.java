package com.cnc.feignclient.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(value="echo",url="http://127.0.0.1:18000/echo")
public interface StoreClient {
    @RequestMapping(method = RequestMethod.GET, value = "/path1")
    String getPath1();
}