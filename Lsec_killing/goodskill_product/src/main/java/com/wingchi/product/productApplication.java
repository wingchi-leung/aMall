package com.wingchi.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wingchi.product.mapper")
public class productApplication {
    public static void main(String[] args) {
        SpringApplication.run(productApplication.class, args) ;
    }
}
