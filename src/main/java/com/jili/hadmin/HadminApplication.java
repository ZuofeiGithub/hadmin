package com.jili.hadmin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = "com.jili.hadmin.dao")
@SpringBootApplication
public class HadminApplication {

    public static void main(String[] args) {
        SpringApplication.run(HadminApplication.class, args);
    }

}
