package com.std.tony.handler_invoke_order_test;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author tony
 * @desc TODO
 * @createDate 2021/3/24 12:27 下午
 */
public class Client {
    public void run(String host, int port) throws Exception {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap()
                    .group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ClientChannelInitialHandler());
            System.out.println("客户端启动");
            Channel channel = bootstrap.connect(host, port).sync().channel();
            // 写入数据
            channel.writeAndFlush("hello world, this is tony");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }

    }


    public static void main(String[] args) {
        Client cli = new Client();
        try {
            cli.run("127.0.0.1", 9999);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
