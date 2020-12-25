package com.malixi.springboot.malixispringboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.malixi.springboot.malixispringboot.entity.DataSourceType;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * 注入数据源
 */
@Configuration
public class DataSourceConfig {
    @Bean
    @ConfigurationProperties("spring.datasource.master")
    public DataSource masterDataSource() {
      //  return DataSourceBuilder.create().build();
      // return new DruidDataSource();
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.slave")
    public DataSource slaveDataSource() {
      //  return DataSourceBuilder.create().build();
        //return new DruidDataSource();
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.slave2")
    public DataSource slave2DataSource() {
        //  return DataSourceBuilder.create().build();
         // 使用阿里的druid
        //return new DruidDataSource();
        return DruidDataSourceBuilder.create().build();
    }

    /**
     * 每增加一个数据源 则增加一个参数
     * @param masterDataSource
     * @param slaveDataSource
     * @param slave2DataSource
     * @return
     */
    @Bean
    @Primary
    public DynamicDataSource dataSource(DataSource masterDataSource, DataSource slaveDataSource,DataSource slave2DataSource) {
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(DataSourceType.MASTER.name(), masterDataSource);
        targetDataSources.put(DataSourceType.SLAVE.name(), slaveDataSource);
        targetDataSources.put(DataSourceType.SLAVE2.name(), slave2DataSource);
        return new DynamicDataSource(masterDataSource, targetDataSources);
    }
}