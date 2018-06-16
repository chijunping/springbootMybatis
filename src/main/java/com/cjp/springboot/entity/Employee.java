package com.cjp.springboot.entity;

import lombok.Data;

@Data
public class Employee {
    private Integer id;
    private String lastName;
    private String email;
    private Integer gender;
    private Integer dId; //MybatisConfig.java和mybatis-config.xml都配置了驼峰命名法，这里就不能写成d_id了
}
