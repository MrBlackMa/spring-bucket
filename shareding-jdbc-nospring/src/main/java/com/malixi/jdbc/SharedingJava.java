package com.malixi.jdbc;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.shardingsphere.api.config.sharding.ShardingRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.TableRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.strategy.InlineShardingStrategyConfiguration;
import org.apache.shardingsphere.shardingjdbc.api.ShardingDataSourceFactory;


import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

/**
 * @Auther: smile malixi
 * @Date: 2020/12/9 - 13:41
 * @Description: com.malixi.jdbc
 * @version: 1.0
 */
public class SharedingJava {
    public static void main(String[] args) {
        // 配置真实数据源
        Map<String, DataSource> dataSourceMap = new HashMap<>();

        // 配置第一个数据源
        DruidDataSource dd1 = new DruidDataSource();
        dd1.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dd1.setUrl("jdbc:mysql://192.168.72.80:3306/shardingsphere");
        dd1.setUsername("root");
        dd1.setPassword("123456");
        dataSourceMap.put("ds1", dd1);

        DruidDataSource dd2 = new DruidDataSource();
        dd2.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dd2.setUrl("jdbc:mysql://192.168.72.81:3306/shardingsphere");
        dd2.setUsername("root");
        dd2.setPassword("123456");
        dataSourceMap.put("ds2", dd2);

        // 配置Order表规则
        TableRuleConfiguration orderTableRuleConfig = new TableRuleConfiguration("t_orders", "ds${1..2}.t_orders_${1..2}");

        // 配置分库 + 分表策略
        orderTableRuleConfig.setDatabaseShardingStrategyConfig(new InlineShardingStrategyConfiguration("id", "ds${id%2+1}"));
        orderTableRuleConfig.setTableShardingStrategyConfig(new InlineShardingStrategyConfiguration("id", "t_orders_${id % 2+1}"));

        // 配置分片规则
        ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
        shardingRuleConfig.getTableRuleConfigs().add(orderTableRuleConfig);


        // 获取数据源对象
        try {
            DataSource dataSource = ShardingDataSourceFactory.createDataSource(dataSourceMap, shardingRuleConfig, new Properties());
            Connection connection = dataSource.getConnection();
            PreparedStatement p = connection.prepareStatement("insert into t_orders values(?,?,?,?)");
            for (int i = 1; i < 11; i++) {
                p.setInt(1, i);
                p.setInt(2, i);
                p.setInt(3, new Random().nextInt(20));
                p.setDouble(4, i * 100.0);
                p.execute();
            }
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
