package com.malixi.spring.dispatcher_one.controller;

import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 模拟浏览器请求获取内容 {
    public static void main(String[] args) {
        try {
            // 创建URL对象
            URL url = new URL("http://192.168.0.31:8425/all");
            System.out.println("开始了吗");
            // 打开URL连接
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // 设置请求方法
            connection.setRequestMethod("GET");

            // 设置请求头
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36");

            // 获取响应码
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // 读取响应数据
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // 输出响应数据
            System.out.println("Response: " + response.toString());
            System.out.println("结束了");

            // 关闭URL连接
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

