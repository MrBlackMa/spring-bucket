package com.malixi.springboot.malixispringboot.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Auther: smile malixi
 * @Date: 2020/12/12 - 14:45
 * @Description: com.malixi.springboot.malixispringboot.entity
 * @version: 1.0
 */

@ConfigurationProperties(prefix = "person") //设置yml群体读取
@Component    //设置为组件
public class Person {
  //  @Value("person.name") 单个设置值 properties的作用
    private String name;
    private String sex;
    private String id;
    private List<String> likes;

    public Person(String name, String sex, String id, List<String> likes) {
        this.name = name;
        this.sex = sex;
        this.id = id;
        this.likes = likes;
    }

    public Person(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getLikes() {
        return likes;
    }

    public void setLikes(List<String> likes) {
        this.likes = likes;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", id='" + id + '\'' +
                ", likes=" + likes +
                '}';
    }
}
