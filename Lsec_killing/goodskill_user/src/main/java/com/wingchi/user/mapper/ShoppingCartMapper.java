package com.wingchi.user.mapper;


import com.wingchi.user.dto.ShoppingCart;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShoppingCartMapper  {
    List<ShoppingCart> selectCartById(@Param("userId") Long userId);

    void insertProduct(@Param("cart")ShoppingCart shoppingCart,@Param("userId")Long userId);

    void updateCart(@Param("num") Integer num, @Param("skuId") Long skuId,@Param("userId") Long userId);

    Integer queryById(@Param("skuId") Long skuId,@Param("userId") Long userId);
}
