package com.example.one.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * tbl_one
 * @author 
 */
@Data
public class TblOne implements Serializable {
    private Integer id;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private static final long serialVersionUID = 1L;
}