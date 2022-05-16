package com.wingchi.order.controller;

import com.alibaba.fastjson.JSON;
import com.wingchi.feign.client.StockClient;
import com.wingchi.order.pojo.OrderDTO;
import com.wingchi.order.pojo.RespBean;
import com.wingchi.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private StockClient stockClient;

    @GetMapping("/{skuId}")
    public String getStockByskuId(@PathVariable Long skuId){
        Integer stock = stockClient.getStockByskuId(skuId);
        return stock.toString() ;
    }

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
