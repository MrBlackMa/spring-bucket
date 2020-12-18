package com.malixi.spring.service2.entity;

/**
 * @Auther: smile malixi
 * @Date: 2020/11/27 - 19:29
 * @Description: com.malixi.springboot.malixispringboot.domain
 * @version: 1.0
 */
public class Person {
    private long id;

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    private String name;

    public Person(long id, String name, String sex, String address) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.address = address;
    }

    public Person(){

    }

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
