package com.malixi.springboot.malixispringboot.domain;

/**
 * @Auther: smile malixi
 * @Date: 2020/11/27 - 19:29
 * @Description: com.malixi.springboot.malixispringboot.domain
 * @version: 1.0
 */
public class Person {
    private long id;

    private String name;
    private String sex;
    private String address;

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public String getAddress() {
        return address;
    }

}
