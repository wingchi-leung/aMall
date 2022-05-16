package com.wingchi.product.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.wingchi.product.beans.RespBean;
import com.wingchi.product.beans.SKU;
import com.wingchi.product.beans.productDto;
import com.wingchi.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class productController {

    @Autowired
    ProductService productService;

    @PostMapping("/getPromoProduct")
    public RespBean getPromoProduct(@RequestBody String categoryName){
        productDto bean = JSON.parseObject(categoryName, productDto.class);
        List<SKU> list = productService.getProductsByCategory(bean.getCategoryName());
        return  new RespBean(list,"001") ;
    }




    @GetMapping("/getDetails/{productId}")
    public RespBean getDetails(@PathVariable String productId) {
        SKU sku = productService.getProductByID(Long.valueOf(productId));
        return new RespBean(sku,"001");
    }

    @PostMapping("/getHotProduct")
    public RespBean getHotProduct(@RequestBody String categoryName){
        productDto bean = JSON.parseObject(categoryName, productDto.class);
        JSONArray jsonArray = JSON.parseArray(bean.getCategoryName());
        List<SKU> list = productService.getProductsByCategory(jsonArray);
        return  new RespBean(list,"001") ;
    }
}
