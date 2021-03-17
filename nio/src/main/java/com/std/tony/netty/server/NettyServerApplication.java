package com.std.tony.netty.server;


public class NettyServerApplication {
    public static void main(String[] args) {
        HttpServer server = new HttpServer(false,8000);
        try {
            server.run();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
