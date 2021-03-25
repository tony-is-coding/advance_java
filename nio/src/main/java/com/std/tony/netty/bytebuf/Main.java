package com.std.tony.netty.bytebuf;

import io.netty.buffer.*;

/**
 * @author tony
 * @desc TODO
 * @createDate 2021/3/19 3:43 下午
 */
public class Main {

    public static void main(String[] args) {
        ByteBuf heapBuf = UnpooledByteBufAllocator.DEFAULT.heapBuffer();
        while (heapBuf.hasArray()){
        }
    }

}
