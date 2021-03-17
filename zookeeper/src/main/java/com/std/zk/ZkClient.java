package com.std.zk;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

import java.util.List;

/**
 * @author tony
 * @createDate 2021/3/12 11:33 上午
 */
public class ZkClient {
    final static String addrString = "114.67.81.63";

    public static void main(String[] args) throws Exception {
        CuratorFramework client = CuratorFrameworkFactory.builder()
                .connectString(addrString)
                .connectionTimeoutMs(2000)
                .sessionTimeoutMs(10000)
                .retryPolicy(new ExponentialBackoffRetry(1000, 3))
                .namespace("myZookeeperTest")
                .build();
        client.start();
//        client.create().forPath("/path");//默认持久化节点,以斜杠开头
//
//        System.out.println(client.getChildren().forPath("/"));

        // 设置临时节点
//        client.create().withMode(CreateMode.PERSISTENT)
//                .forPath("/secondPath", "hello,word".getBytes());
//        System.out.println("节点secondPath的数据" + new String(client.getData().forPath("/secondPath")));
//
//        // 写数据
//        client.setData().forPath("/secondPath", "hello,myWorld!".getBytes());
//        System.out.println("节点secondPath的数据" + new String(client.getData().forPath("/secondPath")));

        client.create()
                .creatingParentContainersIfNeeded()
                .forPath("/secondPath/second2/second3/second4");//递归创建
        List<String> list = client.getChildren().forPath("/secondPath");//查询节点的所有字节点
        System.out.println(list);
        System.out.println(new String(client.getData().forPath("/secondPath/second2/second3/second4")));


//        client.delete().deletingChildrenIfNeeded().forPath("/secondPath/second2");//递归删除
//        System.out.println(client.checkExists().forPath("/secondPath/second2"));//判断节点是否存在
//        System.out.println(client.checkExists().forPath("/secondPath/second2/second3"));//判断节点是否存在
//        System.out.println(client.getChildren().forPath("/secondPath"));
//        client.delete().deletingChildrenIfNeeded().forPath("/secondPath");

    }

}
