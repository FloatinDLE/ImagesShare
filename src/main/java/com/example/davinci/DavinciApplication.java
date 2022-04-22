package com.example.davinci;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.example.davinci.mapper")
@EnableTransactionManagement
public class DavinciApplication {

    public static void main(String[] args) {
        SpringApplication.run(DavinciApplication.class, args);
    }

}
