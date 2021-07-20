package com.std.tony.echo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

@ChannelHandler.Sharable
public class EchoServer {
    private int port;

    public EchoServer(int port) {
        this.port = port;
    }

    public void run() throws Exception {
        // 创建一个 接受组线程 和 处理组线程
        EventLoopGroup parentEventGroup = new NioEventLoopGroup();
        EventLoopGroup childEventGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap
                    .group(parentEventGroup, childEventGroup)
                    .localAddress(new InetSocketAddress(port))
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new EchoServerHandler());
                        }
                    })
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
            ;
            // 绑定配置并开始监听
            ChannelFuture future = bootstrap.bind().sync();

            // 等待服务器 socket 关闭
            // 优雅的关闭服务器
            future.channel().closeFuture().sync();

        } finally {
            // 关闭
            childEventGroup.shutdownGracefully().sync();
            parentEventGroup.shutdownGracefully().sync();
        }
    }

    public static void main(String[] args) throws Exception {
        int port = 8000;
        new EchoServer(port).run();
    }
}
