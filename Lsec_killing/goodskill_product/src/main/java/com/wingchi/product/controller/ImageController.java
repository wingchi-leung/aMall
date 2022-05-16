package com.wingchi.product.controller;

import com.alibaba.fastjson.JSON;
import com.wingchi.product.beans.Image;
import com.wingchi.product.beans.RespBean;
import com.wingchi.product.beans.productDto;
import com.wingchi.product.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * mylist.vue 需要home的mylist作为组件
 * 需要好好把前端捋一遍，才能设计后端的变量名称，一一对应啊！
 */

@RestController
@RequestMapping("/product")
public class ImageController {

    @Autowired
    ImageService imageService ;


    @RequestMapping("/carousel")
    public RespBean getCarousel() {
        List<Image> carousel = imageService.Getcarousel() ;
        return new RespBean(carousel,"001") ;
    }


    @PostMapping("/getDetailsPicture")
    public RespBean getDetails(@RequestBody String productId) {
        productDto bean = JSON.parseObject(productId, productDto.class);
        List<Image> list = imageService.getDetailPicture(bean.getProductId());
        return new RespBean(list,"001");
    }


}
