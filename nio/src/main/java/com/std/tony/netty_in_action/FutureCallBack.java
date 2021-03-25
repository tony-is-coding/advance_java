package com.std.tony.netty_in_action;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.sctp.nio.NioSctpChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

/**
 * @author tony
 * @desc TODO
 * @createDate 2021/3/18 8:26 下午
 */
public class FutureCallBack {
    public static void main(String[] args) {
        Channel ch = new NioServerSocketChannel();
        ChannelFuture cf = ch.connect(new InetSocketAddress("127.0.0.1", 25));
    }
}
