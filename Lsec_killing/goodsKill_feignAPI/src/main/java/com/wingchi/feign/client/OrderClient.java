package com.wingchi.feign.client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;


@FeignClient(value="orderService" ,configuration = FeignClient.class)
public class OrderClient {

}
