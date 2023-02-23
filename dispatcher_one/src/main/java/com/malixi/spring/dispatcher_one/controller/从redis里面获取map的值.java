package com.malixi.spring.dispatcher_one.controller;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class 从redis里面获取map的值 {
    public static void main(String[] args) {
        String redisHost = "45.200.57.4"; // Redis服务器地址
        int redisPort = 6379; // Redis服务器端口号
        String redisPassword = "malixi"; // Redis服务器密码
        int redisTimeout = 2000; // 连接Redis超时时间

        // 配置Jedis连接池
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(10);
        poolConfig.setMaxIdle(5);

        // 创建Jedis连接池
        JedisPool jedisPool = new JedisPool(poolConfig, redisHost, redisPort, redisTimeout, redisPassword);

        try (Jedis jedis = jedisPool.getResource()) {
            // 从Redis的map中获取value值
            String value = jedis.hget("adsl", "adsl22");

            // 打印获取的value值
            System.out.println("Value: " + value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭Jedis连接池
            jedisPool.close();
        }
    }
}


