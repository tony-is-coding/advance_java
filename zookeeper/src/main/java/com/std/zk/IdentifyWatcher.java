package com.std.zk;

import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.curator.framework.api.CuratorListener;
import org.apache.curator.framework.api.UnhandledErrorListener;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author tony
 * @desc TODO
 * @createDate 2021/3/12 3:28 下午
 */
@Slf4j
public class IdentifyWatcher {
    final static String addrString = "114.67.81.63";

    public static void main(String[] args) {
        CuratorFramework zkClient = CuratorFrameworkFactory.builder()
                .connectString(addrString)
                .connectionTimeoutMs(2000)
                .sessionTimeoutMs(10000)
                .retryPolicy(new ExponentialBackoffRetry(1000, 3))
                .namespace("myZookeeperTest")
                .build();

        zkClient.getCuratorListenable().addListener((client, event) -> {
            try {
                switch (event.getType()) {
                    case DELETE:
                    case CREATE:
                    default:
                        System.out.printf("catch a [%s] type event", event.getType());
                        break;
                }
            } catch (Exception e) {
                log.info(e.toString());
                try {
                    client.close();
                } catch (Exception e2) {
                    e.printStackTrace();
                }
            }
        });

        zkClient.getUnhandledErrorListenable().addListener((message, e) -> {
            log.error("Unrecoverable Error:" + message, e);
            try {
                zkClient.close();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });


    }
}
