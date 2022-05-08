package com.wingchi.order.controller;

import com.alibaba.fastjson.JSON;
import com.wingchi.order.pojo.OrderDTO;
import com.wingchi.order.pojo.RespBean;
import com.wingchi.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/addOrder")
    public RespBean addOrder(@RequestBody String orderDetails) {
        OrderDTO orderDTO = JSON.parseObject(orderDetails,OrderDTO.class);
        orderService.addOrder(orderDTO);
        return new RespBean("001","成功");
    }

    @PostMapping("/getOrder")
    public RespBean getOrder(@RequestBody String userId){
        OrderDTO orderDTO = JSON.parseObject(userId,OrderDTO.class);
        List<OrderDTO> orderList = orderService.getOrder(orderDTO.getUserId());
        return new RespBean("001","成功",orderList);
    }
}
