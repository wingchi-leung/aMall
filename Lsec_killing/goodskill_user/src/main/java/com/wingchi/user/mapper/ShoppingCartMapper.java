package com.wingchi.user.mapper;


import com.wingchi.user.vo.ShoppingCart;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShoppingCartMapper  {
    List<ShoppingCart> selectCartById(@Param("userId") Long userId);
}
