package com.wingchi.order.service;

import com.wingchi.order.mapper.OrderMapper;
import com.wingchi.order.pojo.Order;
import com.wingchi.order.pojo.OrderDTO;
import com.wingchi.order.pojo.OrderDetail;
import com.wingchi.order.pojo.OrderDetailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderMapper orderMapper ;
    public void addOrder(OrderDTO orderDTO){
        List<OrderDetailDTO> list = orderDTO.getCartList();
        double total=orderDTO.getTotalPrice();
        Order order = new Order(total,total,0.0, orderDTO.getUserId(),0,1) ;
        orderMapper.insertByUserId(order);
        Long orderId = order.getId();
        List<OrderDetail> details =new ArrayList<>();
        for (OrderDetailDTO dto:list) {
            // 封装成orderDetail
            OrderDetail orderDetail = new OrderDetail(
                    orderId,dto.getSkuId(),dto.getAmount(),dto.getSkuName(),dto.getPrice(),dto.getSkuImage());
            details.add(orderDetail) ;
        }
        orderMapper.insertDetailByOrder(details);
    }


    public List<OrderDTO> getOrder(Long userId) {
        return orderMapper.getOrderByUserId(userId) ;
    }
}
