package com.zhdj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zhdj.mappers")
public class ZhdjBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZhdjBootApplication.class, args);
    }

}
