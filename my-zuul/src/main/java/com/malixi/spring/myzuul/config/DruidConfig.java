package com.malixi.spring.myzuul.config;
import com.alibaba.druid.pool.DruidDataSource;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;


/**
 * 德鲁伊的配置类
 *
 */

@Configuration
public class DruidConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.druid")
    public DataSource druidDataSource(){
//        DruidDataSource druidDataSource = new DruidDataSource();
//        druidDataSource.setUrl("");
        //return new DruidDataSource();
      return   DruidDataSourceBuilder.create().build();
    }

}