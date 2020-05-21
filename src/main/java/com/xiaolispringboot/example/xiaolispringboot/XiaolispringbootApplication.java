package com.xiaolispringboot.example.xiaolispringboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
@MapperScan(basePackages = "com.xiaolispringboot.example.xiaolispringboot.mapper")
public class XiaolispringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(XiaolispringbootApplication.class, args);
    }

}
