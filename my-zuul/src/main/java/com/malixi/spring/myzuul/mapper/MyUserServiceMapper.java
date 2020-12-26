package com.malixi.spring.myzuul.mapper;

import com.malixi.spring.myzuul.entity.Users;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Auther: smile malixi
 * @Date: 2020/12/25 - 20:45
 * @Description: com.malixi.spring.myzuul.mapper
 * @version: 1.0
 */
@Mapper
@Repository
public interface MyUserServiceMapper {
    List<Map<String,Object>> selectUsers(String userName);
}
