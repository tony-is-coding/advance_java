package com.std.tony.handler_invoke_order_test;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

/**
 * @author tony
 * @desc TODO
 * @createDate 2021/3/24 2:29 下午
 */
public class ClientChannelInitialHandler extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        System.out.println("连接创建成功... ");
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast("encode",new ServerEncoder());
    }
}
