package com.malixi.spring.dispatcher_one.controller;

import redis.clients.jedis.*;


import java.util.HashSet;
import java.util.Set;

public class RedisExample {
    public static void main(String[] args) {
        // Redis 服务器信息
        String redisHost = "45.200.57.4";
        int redisPort = 6379;
        String redisPassword = "malixi";

        // 创建 Redis 连接池
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(128);
        JedisPool jedisPool = new JedisPool(poolConfig, redisHost, redisPort, 5000, redisPassword);

        // 从 Redis 连接池中获取一个 Jedis 实例
        Jedis jedis = jedisPool.getResource();

        // 设置 SCAN 命令的参数，包括 MATCH 和 COUNT 选项
        ScanParams scanParams = new ScanParams().match("adsl*").count(100);

        // 使用 SCAN 命令获取 Redis 中以 "adsl" 开头的所有 key
        String cursor = "0";
        Set<String> adslKeys = new HashSet<>();
        do {
            ScanResult<String> scanResult = jedis.scan(cursor, scanParams);
            cursor = scanResult.getCursor();
            adslKeys.addAll(scanResult.getResult());
        } while (!cursor.equals("0"));

        // 输出所有 key
        for (String key : adslKeys) {
            System.out.println(key);
            // 从Redis的map中获取value值
            String value = jedis.hget("adsl", "adsl22");

            // 打印获取的value值
            System.out.println("Value: " + value);
        }

        // 关闭 Jedis 连接
        jedis.close();

        // 关闭 Redis 连接池
        jedisPool.close();
    }
}
