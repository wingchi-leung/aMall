package com.wingchi.order.mapper;

import com.wingchi.order.pojo.Order;
import com.wingchi.order.pojo.OrderDTO;
import com.wingchi.order.pojo.OrderDetail;


import java.util.List;

public interface OrderMapper {

    public void insertByUserId(Order order);

    void insertDetailByOrder(List<OrderDetail> details);


    List<OrderDTO> getOrderByUserId(Long userId);
}
