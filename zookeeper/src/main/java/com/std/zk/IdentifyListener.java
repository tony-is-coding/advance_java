package com.std.zk;

import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.curator.framework.api.CuratorListener;

/**
 * @author tony
 * @desc TODO
 * @createDate 2021/3/12 3:40 下午
 */
@Slf4j
public class IdentifyListener implements CuratorListener {

    @Override
    public void eventReceived(CuratorFramework client, CuratorEvent event) throws Exception {
        try {
            switch (event.getType()) {
                case DELETE:
                    System.out.println();
                    break;
                case CREATE:
                    System.out.println();
                    break;
                default:
                    System.out.println();
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

    }
}
