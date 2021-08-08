package com.cnc.testing;

import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {
    @Override
    public String getTestString() {
        return "hello world";
    }
}
