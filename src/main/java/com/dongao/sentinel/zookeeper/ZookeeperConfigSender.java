package com.dongao.sentinel.zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

/**
 * Zookeeper config sender for demo
 *
 * @author guonanjun
 */
public class ZookeeperConfigSender {

    private static final int RETRY_TIMES = 3;
    private static final int SLEEP_TIME = 1000;

    public static void main(String[] args) throws Exception {
        final String remoteAddress = "192.168.56.101:2181";
        final String groupId = "Sentinel-Demo";
        final String dataId = "SYSTEM-CODE-DEMO-FLOW";
        final String rule = "[{\n" +
                "\t\"limitApp\":\"default\",\n" +
                "\t\"count\":2,\n" +
                "\t\"grade\":1,\n" +
                "\t\"resource\":\"hello\"\n" +
                "}]";
        CuratorFramework zkClient = CuratorFrameworkFactory.newClient(remoteAddress, new ExponentialBackoffRetry(SLEEP_TIME, RETRY_TIMES));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        zkClient.start();
        String path = getPath(groupId, dataId);
        Stat stat = zkClient.checkExists().forPath(path);
        if (stat == null) {
            zkClient.create().creatingParentContainersIfNeeded().withMode(CreateMode.PERSISTENT).forPath(path, null);
        }
        zkClient.setData().forPath(path, rule.getBytes());

        zkClient.close();

    }

    private static String getPath(String groupId, String dataId) {
        String path = "";
        if (groupId.startsWith("/")) {
            path += groupId;
        } else {
            path += "/" + groupId;
        }
        if (dataId.startsWith("/")) {
            path += dataId;
        } else {
            path += "/" + dataId;
        }
        return path;
    }
}