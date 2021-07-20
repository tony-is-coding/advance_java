package com.std.tony.handler_invoke_order_test;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

/**
 * @author tony
 * @desc TODO
 * @createDate 2021/3/24 2:40 下午
 */
public class ServerBusinessHandler2 extends ChannelOutboundHandlerAdapter {
    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        System.out.println("biz2 handler invoked ...");
        System.out.println(msg);
        System.out.println(ctx.channel().write(msg));
        ctx.write(msg);
        ctx.flush();
    }

}
