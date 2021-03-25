package com.std.tony.handler_invoke_order_test;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author tony
 * @desc TODO
 * @createDate 2021/3/24 2:37 下午
 */
@Slf4j
public class ServerBusinessHandler1 extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("biz1 handler invoked ...");
        ctx.writeAndFlush(msg);
    }

}
