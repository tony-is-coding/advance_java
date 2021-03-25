package com.std.tony.handler_invoke_order_test;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * @author tony
 * @desc TODO
 * @createDate 2021/3/24 2:32 下午
 */
@Slf4j
public class ServerDecoder extends ByteToMessageDecoder {
    private static final int MAX_READ_FRAME_SIZE = 1024;
    private static final int MIN_READ_FRAME_SIZE = 16;

    // 当有数据写入到 channel 对应的 ByteBuf 时, 则进行一次读取尝试;
    // List<Object> 相当于后续任务的一个执行串, 没一个元素会被后续所以handler 处理一次
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        System.out.println("server decode called");
        if (in.readableBytes() > 16) {
            byte[] bs = new byte[in.readableBytes()];
            in.readBytes(in.readableBytes()).getBytes(0, bs);
            if (bs.length > 0) {
                out.add(new String(bs));
            }
        }
    }
}
