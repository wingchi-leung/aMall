package com.wingchi.stock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class stockApplication {
    public static void main(String[] args) {
        SpringApplication.run(stockApplication.class,args);
    }
}
