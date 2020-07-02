package com.deng;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.deng.mapper")
@SpringBootApplication
public class FotestApplication {

    public static void main(String[] args) {
        SpringApplication.run(FotestApplication.class, args);
    }

}
