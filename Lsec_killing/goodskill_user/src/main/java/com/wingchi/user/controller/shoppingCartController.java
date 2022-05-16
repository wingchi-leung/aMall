package com.wingchi.user.controller;

import com.alibaba.fastjson.JSON;
import com.wingchi.user.bean.RespBean;
import com.wingchi.user.service.ShoppingCartService;
import com.wingchi.user.dto.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/shoppingCart")
public class shoppingCartController {

    @Autowired
    ShoppingCartService cartService;

    @GetMapping("/{userId}")
    public RespBean getShoppingCart(@PathVariable String userId){
        List<ShoppingCart> shoppingCart = cartService.getShoppingCartById(Long.valueOf(userId));
        return new RespBean("001","成功",shoppingCart);
    }

    /**
     * 更新购物车中商品的值
     */
    @PutMapping("/{userId}/{productId}/{num}")
    public RespBean updateShoppingCart(@PathVariable String num, @PathVariable String productId, @PathVariable String userId) {
        System.out.println(num);
        System.out.println(productId);
        System.out.println(userId);
        cartService.updateCart(Integer.valueOf(num), Long.valueOf(productId), Long.valueOf(userId));
        return new RespBean("001", "成功", null);
    }

    /**
     * 添加商品到购物车
     */
    @PostMapping("/{userId}")
    public RespBean addShoppingCart(@RequestBody String product,
                                    @PathVariable String userId) {
        System.out.println(product);
        ShoppingCart shoppingCart = JSON.parseObject(product, ShoppingCart.class);
        System.out.println(shoppingCart);
        String code = cartService.addProduct(shoppingCart, Long.valueOf(userId));
        return new RespBean(code,"成功",null);
    }

}
