package com.wingchi.product.controller;

import com.wingchi.product.beans.RespBean;
import com.wingchi.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class SeckillController {

    @Autowired
    ProductService productService;

    @GetMapping("secKill")
    public RespBean getSeckillProduct(){
        productService.getSeckillProduct() ;
    }
}
