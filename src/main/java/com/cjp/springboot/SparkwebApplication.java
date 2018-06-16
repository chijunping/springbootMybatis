package com.cjp.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@MapperScan(value = "com.cjp.springboot.mapper")//这样mapp包下就不要每个mapp.java都加@Mapper注解了
@EnableScheduling
@SpringBootApplication
public class SparkwebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SparkwebApplication.class, args);
    }
}
