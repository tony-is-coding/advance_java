package com.std.tony.handler_invoke_order_test;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;


/**
 * @author tony
 * @desc TODO
 * @createDate 2021/3/24 2:33 下午
 */
public class ServerEncoder extends MessageToByteEncoder<String> {


    @Override
    protected void encode(ChannelHandlerContext ctx, String msg, ByteBuf out) throws Exception {
        System.out.println("server encode called ...");
        if (msg.length() == 0) {
            System.out.println("no message passed");
            return;
        }
        out.writeBytes(msg.getBytes());
    }
}
