package com.malixi.spring.dispatcher_one.controller;

import redis.clients.jedis.*;

import java.util.*;

public class RedisHashExample {
    public static void main(String[] args) {
        // Redis 服务器地址和端口号
        String redisHost = "45.200.57.4";
        int redisPort = 6379;

        // Redis 认证信息
//        String redisUsername = "your-redis-username";
        String redisPassword = "malixi";

        // Redis 连接池配置
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        JedisPool jedisPool = new JedisPool(poolConfig, redisHost, redisPort, Protocol.DEFAULT_TIMEOUT,  redisPassword);

        // Redis 连接
        try (Jedis jedis = jedisPool.getResource()) {
            // 获取所有 key 值类似于 "adsl" 的哈希表中的键值对
            ScanParams params = new ScanParams().match("*adsl*");
            String cursor = "0";
            Map<String, String> hash = new HashMap<>();

//            // 设置 SCAN 命令的参数，包括 MATCH 和 COUNT 选项
//            ScanParams scanParams = new ScanParams().match("adsl*").count(100);
//            Set<String> adslKeys = new HashSet<>();
//            do {
//                ScanResult<String> scanResult = jedis.scan(cursor, scanParams);
//                cursor = scanResult.getCursor();
//                adslKeys.addAll(scanResult.getResult());
//            } while (!cursor.equals("0"));

            do {
                ScanResult<Map.Entry<String, String>> scanResult = jedis.hscan("adsl", cursor, params);
                List<Map.Entry<String, String>> entrySet = scanResult.getResult();

                for (Map.Entry<String, String> entry : entrySet) {
                    String key = entry.getKey();
                    String value = entry.getValue();

                    hash.put(key, value);
                }

                cursor = scanResult.getCursor();
            } while (!cursor.equals("0"));

            // 输出所有键值对
            for (Map.Entry<String, String> entry : hash.entrySet()) {
                System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
            }
        }

        // 关闭连接池
        jedisPool.close();
    }
}
