package com.wingchi.user.service;

import com.wingchi.user.mapper.ShoppingCartMapper;
import com.wingchi.user.vo.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartService {

    @Autowired
    ShoppingCartMapper CartMapper;

    public List<ShoppingCart> getShoppingCartById(Long Userid ){
        List<ShoppingCart> carts = CartMapper.selectCartById(Userid);
        for(ShoppingCart cart:carts) cart.setCheck(false) ;
        return carts;
    }
}
