package com.malixi.spring.service2.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Auther: smile malixi
 * @Date: 2021/4/7 - 11:00
 * @Description: com.malixi.spring.service2.model
 * @version: 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Model implements Serializable {


    private Long id;


    private String name;


}
