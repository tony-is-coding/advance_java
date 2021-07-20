package com.std.tony.handler_invoke_order_test;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;


/**
 * @author tony
 * @desc TODO
 * @createDate 2021/3/24 12:27 下午
 */
public class Server {

    public void run(int port) throws InterruptedException {
        EventLoopGroup scheduler = new NioEventLoopGroup();
        EventLoopGroup worker = new NioEventLoopGroup();
        try {
            ServerBootstrap bs = new ServerBootstrap();
            bs
                    .group(scheduler, worker)
                    .localAddress(new InetSocketAddress(port))
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ServerChannelInitialHandler())
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, true);
            System.out.println("服务启动成功 ...");
            ChannelFuture future = bs.bind().sync();
            future.channel().closeFuture().sync();
        } finally {
            scheduler.shutdownGracefully().sync();
            worker.shutdownGracefully().sync();
        }
    }

    public static void main(String[] args) {
        Server sv = new Server();
        try {
            sv.run(9999);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
