package com.malixi.spring.dispatcher_one.controller;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.*;

public class 打开linux文件修改linux的文件 {

    public static void main(String[] args) {
        String redisIP = getRedisIP(); // 从Redis获取IP
        String configFile = "/path/to/stunnel.conf"; // stunnel.conf文件路径
        modifyStunnelConfig(configFile, redisIP); // 修改stunnel.conf文件
        executeShellScript("/path/to/stunnel.sh"); // 执行stunnel.sh脚本
    }

    private static String getRedisIP() {
        String redisHost = "45.200.57.4"; // Redis服务器地址
        int redisPort = 6379; // Redis服务器端口号
        String redisPassword = "malixi"; // Redis服务器密码
        int redisTimeout = 2000; // 连接Redis超时时间
        String value="";

        // 配置Jedis连接池
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(10);
        poolConfig.setMaxIdle(5);

        // 创建Jedis连接池
        JedisPool jedisPool = new JedisPool(poolConfig, redisHost, redisPort, redisTimeout, redisPassword);

        try (Jedis jedis = jedisPool.getResource()) {
            // 从Redis的map中获取value值
             value = jedis.hget("adsl", "adsl22");

            // 打印获取的value值
            System.out.println("Value: " + value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭Jedis连接池
            jedisPool.close();
        }
        return value;
    }

    private static void modifyStunnelConfig(String configFile, String redisIP) {
        try {
            // 读取stunnel.conf文件
            BufferedReader reader = new BufferedReader(new FileReader(configFile));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("connect")) {
                    // 修改connect配置为从Redis获取的IP
                    line = "connect = " + redisIP;
                }
                sb.append(line).append("\n");
            }
            reader.close();
            // 将修改后的内容写入stunnel.conf文件
            FileWriter writer = new FileWriter(configFile);
            writer.write(sb.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void executeShellScript(String scriptFile) {
        try {
            // 构造执行shell脚本的命令
            String[] cmd = { "/bin/sh", "-c", scriptFile };
            // 执行shell脚本
            Process process = Runtime.getRuntime().exec(cmd);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

