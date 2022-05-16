package com.wingchi.feign.client;

import com.wingchi.feign.config.FeignConfig;
import com.wingchi.feign.pojo.RespBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "Stock",configuration = FeignConfig.class)
@RequestMapping("/stock")
public interface StockClient {

    @GetMapping("/{skuId}")
    public Integer getStockByskuId(@PathVariable("skuId") Long skuId) ;
}
