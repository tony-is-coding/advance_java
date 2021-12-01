package com.cnc.spi.impl;

import com.cnc.spi.interfaces.SPIInterface;

public class JackSPIInterface implements SPIInterface {
    @Override
    public String getName() {
        return "jack";
    }
}
