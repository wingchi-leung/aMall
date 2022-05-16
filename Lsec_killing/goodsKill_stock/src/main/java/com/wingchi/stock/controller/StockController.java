package com.wingchi.stock.controller;

import com.wingchi.stock.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stock")
public class StockController {
    @Autowired
    StockService stockService ;


    @GetMapping("/{skuId}")
    public Integer getStockByskuId(@PathVariable Long skuId) {
        System.out.println(skuId);
        Integer stock = stockService.getStockByskuId((skuId));
        return stock;
//        return new RespBean("001",stock,"成功") ;
    }


}
