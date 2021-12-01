package com.cnc.spi;

import com.cnc.spi.interfaces.SPIInterface;

import java.util.ServiceLoader;

public class Main {

    public static void main(String[] args) {
        ServiceLoader<SPIInterface> loader = ServiceLoader.load(SPIInterface.class);
        for (SPIInterface impl : loader) {
            System.out.println(impl.getName());
        }
    }
}

