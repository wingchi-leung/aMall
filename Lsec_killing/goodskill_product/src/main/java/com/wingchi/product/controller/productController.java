package com.wingchi.product.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wingchi.product.beans.Image;
import com.wingchi.product.beans.RespBean;
import com.wingchi.product.beans.SKU;
import com.wingchi.product.beans.jsonBean;
import com.wingchi.product.mapper.ProductMapper;
import com.wingchi.product.service.ProductService;
import org.bouncycastle.pqc.crypto.rainbow.RainbowSigner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class productController {

    @Autowired
    ProductService productService;


    /**
     * 根据商品类别名称获取该类别的商品列表
     */
    @PostMapping("/getPromoProduct")
    public RespBean getPromoProduct(@RequestBody String categoryName){
//        字符串封装成bean对象。
        jsonBean bean = JSON.parseObject(categoryName,jsonBean.class);
        List<SKU> list = productService.getProductsByCategory(bean.getCategoryName());
        return  new RespBean(list,"001") ;
    }


    @PostMapping("/getHotProduct")
    public RespBean getHotProduct(@RequestBody String categoryName){
        jsonBean bean = JSON.parseObject(categoryName,jsonBean.class);
        JSONArray jsonArray = JSON.parseArray(bean.getCategoryName());
        List<SKU> list = productService.getProductsByCategory(jsonArray);
        return  new RespBean(list,"001") ;
    }

    @PostMapping("/getDetails")
    public RespBean getDetails(@RequestBody String productId) {
        jsonBean bean = JSON.parseObject(productId, jsonBean.class);
        SKU sku = productService.getProductByID(bean.getProductId());
        return new RespBean(sku,"001");
    }
}
