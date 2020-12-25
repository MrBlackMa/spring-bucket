package com.malixi.springboot.malixispringboot.controller;

import com.malixi.springboot.malixispringboot.config.DataSource;
import com.malixi.springboot.malixispringboot.entity.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 对应springboot二期的内容
 */
@RestController
public class EmpController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/master")
    @DataSource(value = DataSourceType.MASTER)
    public List<Map<String, Object>> local(){
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from t_malixi");
        return maps;
    }
    @GetMapping("/slave")
    @DataSource(value = DataSourceType.SLAVE)
    public List<Map<String, Object>> remote(){
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from t_malixi");
        return maps;
    }

    @GetMapping("/slave2")
    @DataSource(value = DataSourceType.SLAVE2)
    public List<Map<String, Object>> remote2(){
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from t_malixi");
        return maps;
    }

}