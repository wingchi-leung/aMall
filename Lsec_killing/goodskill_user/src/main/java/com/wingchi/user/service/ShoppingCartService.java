package com.wingchi.user.service;

import com.wingchi.user.mapper.ShoppingCartMapper;
import com.wingchi.user.dto.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartService {

    @Autowired
    ShoppingCartMapper CartMapper;

    // 查询购物车列表。
    public List<ShoppingCart> getShoppingCartById(Long Userid ){
        List<ShoppingCart> carts = CartMapper.selectCartById(Userid);
        for(ShoppingCart cart:carts) cart.setCheck(false) ;
        return carts;
    }

    //
    public String addProduct(ShoppingCart shoppingCart,Long userId) {
//        查询商品是否已经存在用户的购物车内
        Integer amount = CartMapper.queryById(shoppingCart.getSkuId(), userId);
        String code ;
        if(amount==null){
            CartMapper.insertProduct(shoppingCart, userId);
            code="001" ;
        }else {
            updateCart(shoppingCart.getAmount() + 1, shoppingCart.getSkuId(), userId);
            code="002" ;
        }
        return code;
    }

    public void updateCart(Integer num, Long productId, Long userId) {
        CartMapper.updateCart(num,productId,userId) ;
    }
}
