package com.example.standard;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.standard.mapper")
public class StandardApplication {

    public static void main(String[] args) {
        SpringApplication.run(StandardApplication.class, args);
    }

}
