package com.std.tony.iomulti.reactor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.*;

/**
 * com.std.tony.iomulti.reactor - MasterSlaveReactor
 *
 * @author tony-is-coding
 * @date 2022/5/22 22:10
 */
public class MasterSlaveReactor {
    public static void main(String[] args) {
        new MasterReactor(8001).run();
    }
}

class MasterReactor {
    private final int port;
    private SlaveReactor slave;
    private Selector selector;

    public MasterReactor(int port) {
        this.port = port;
    }

    @SuppressWarnings("all")
    public void run() {
        try {
            selector = Selector.open();
            final ServerSocketChannel ssc = ServerSocketChannel.open();
            ssc.configureBlocking(false);
            ssc.socket().bind(new InetSocketAddress(port), 1024);
            ssc.register(selector, SelectionKey.OP_ACCEPT);
            slave = new SlaveReactor();
            slave.run();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        System.out.println("主reactor开始启动了,监听端口：" + port + ".......");
        for (; ; ) {
            try {
                selector.select(1000);
                Set<SelectionKey> selectedKeys = selector.selectedKeys();
                Iterator<SelectionKey> it = selectedKeys.iterator();
                SelectionKey key;
                while (it.hasNext()) {
                    key = it.next();
                    it.remove();
                    try {
                        dispatch(key);
                    } catch (Exception e) {
                        if (key != null) {
                            key.cancel();
                            if (key.channel() != null)
                                key.channel().close();
                        }
                    }
                }
            } catch (Throwable t) {
                t.printStackTrace();
            }
        }
    }

    private void dispatch(SelectionKey key) {
        if (key.isValid() && key.isAcceptable()) {
            new AcceptHandler(key, slave).run();
        }
    }
}

class SlaveReactor {
    private Selector selector;

    public SlaveReactor() {
        try {
            selector = Selector.open();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    /**
     * 将主Reactor中的Channel注册到从Reactor中的selector
     */
    public void register(SocketChannel sc) {
        try {
            sc.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);
        } catch (ClosedChannelException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("all")
    public void run() {
        new Thread(() -> {
            System.out.println("从reactor开始启动了。。。。。");
            for (; ; ) {
                try {
                    selector.select(1000);
                    final Set<SelectionKey> selectedKeys = selector.selectedKeys();
                    final int size = selectedKeys.size();
                    Iterator<SelectionKey> it = selectedKeys.iterator();
                    CountDownLatch latch = new CountDownLatch(size);
                    while (it.hasNext()) {
                        final SelectionKey key = it.next();
                        it.remove();
                        try {
                            if (key.isValid()) {
                                if (key.isReadable())
                                    new ReadHandler(key).run();
                                if (key.isWritable())
                                    new writeHandler(key).run();
                            }
                        } catch (Exception e) {
                            if (key != null) {
                                key.cancel();
                                if (key.channel() != null)
                                    key.channel().close();
                            }
                        }
                    }
                } catch (Throwable t) {
                    t.printStackTrace();
                }
            }
        }).start();
    }

}

class AcceptHandler {

    private final SlaveReactor slave;
    private final SelectionKey selectionKey;

    public AcceptHandler(SelectionKey selectionKey, SlaveReactor slave) {
        this.selectionKey = selectionKey;
        this.slave = slave;
    }
    public void run() {
        try {
            ServerSocketChannel ssc = (ServerSocketChannel) selectionKey.channel();
            SocketChannel sc = ssc.accept();
            sc.configureBlocking(false);
            System.out.println("acceptable ...");
            slave.register(sc);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

class ReadHandler {
    private final SelectionKey selectionKey;
    public ReadHandler(SelectionKey selectionKey) {
        this.selectionKey = selectionKey;
    }
    public void run() {
        final SocketChannel sc = (SocketChannel) selectionKey.channel();
        System.out.println("readable ...");
        ByteBuffer readBuff = ByteBuffer.allocate(1024);
        try {
            int count = sc.read(readBuff);
            String msg = new String(readBuff.array(), 0, count);
            System.out.printf("接受到客户端信息: [ %s ] \n", msg);
            readBuff.flip();
            sc.register(selectionKey.selector(), SelectionKey.OP_WRITE);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            readBuff.clear();
        }
    }
}


class writeHandler {
    private final SelectionKey selectionKey;
    public writeHandler(SelectionKey selectionKey) {
        this.selectionKey = selectionKey;
    }
    public void run() {
        final SocketChannel sc = (SocketChannel) selectionKey.channel();
        System.out.println("writeable ... ");
        ByteBuffer writeBuff = ByteBuffer.allocate(128);
        try {
            writeBuff.put("this is a response".getBytes());
            writeBuff.flip();
            sc.write(writeBuff);
            sc.register(selectionKey.selector(), SelectionKey.OP_READ);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            writeBuff.clear();
        }
    }
}

