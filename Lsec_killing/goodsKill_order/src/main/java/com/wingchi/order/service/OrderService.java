package com.wingchi.order.service;

import com.wingchi.feign.client.StockClient;
import com.wingchi.feign.pojo.RespBean;
import com.wingchi.order.mapper.OrderMapper;
import com.wingchi.order.pojo.Order;
import com.wingchi.order.pojo.OrderDTO;
import com.wingchi.order.pojo.OrderDetail;
import com.wingchi.order.pojo.OrderDetailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
//'订单的状态，
// 0、未付款
// 1、已付款,未发货
// 2、已发货,未确认
// 3、确认收货，交易成功
// 4、交易取消，订单关闭
// 5、交易结束，已评价',
@Service
public class OrderService {
    @Autowired
    private StockClient stockClient;

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
