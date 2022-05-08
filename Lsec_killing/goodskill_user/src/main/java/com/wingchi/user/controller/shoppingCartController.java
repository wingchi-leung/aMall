package com.wingchi.user.controller;

import com.alibaba.fastjson.JSON;
import com.wingchi.user.bean.userSkuDto;
import com.wingchi.user.bean.RespBean;
import com.wingchi.user.service.ShoppingCartService;
import com.wingchi.user.vo.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user/shoppingCart")
public class shoppingCartController {

    @Autowired
    ShoppingCartService cartService;
    
    
    @PostMapping("/getShoppingCart")
    public RespBean getShoppingCart(@RequestBody String userId){
        userSkuDto jsonBean = JSON.parseObject(userId, userSkuDto.class);
        List<ShoppingCart> shoppingCart = cartService.getShoppingCartById(jsonBean.getUserId());
        return new RespBean("001","成功",shoppingCart);
    }

    @PostMapping("/updateShoppingCart")
    public RespBean updateShoppingCart(@RequestBody String data) {
        return null;
    }

    @PostMapping("/addShoppingCart")
    public RespBean addShoppingCart(@RequestBody String detail) {
        userSkuDto dto = JSON.parseObject(detail, userSkuDto.class);

        return null;
    }

}
