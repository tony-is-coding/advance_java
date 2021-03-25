package com.std.tony.handler_invoke_order_test;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import lombok.extern.slf4j.Slf4j;

/**
 * @author tony
 * @desc TODO
 * @createDate 2021/3/24 2:28 下午
 */
@Slf4j
public class ServerChannelInitialHandler extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        /**
         所以建议实际使用上，先通过addFirst插入所有outBound, 再通过addLast插入所有inBound
         */

        System.out.println("server initialized ...");
        ChannelPipeline pipeline = ch.pipeline();

        // 出站将按一下顺序执行
        pipeline.addFirst("handler2", new ServerBusinessHandler2());
        pipeline.addFirst("encode", new ServerEncoder());

        // 入栈将按以下顺序执行
        pipeline.addLast("decode", new ServerDecoder());
        pipeline.addLast("handler1", new ServerBusinessHandler1());
    }
}
