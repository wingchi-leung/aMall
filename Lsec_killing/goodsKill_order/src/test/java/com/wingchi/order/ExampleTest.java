package com.wingchi.order;

import com.wingchi.order.mapper.OrderMapper;
import com.wingchi.order.pojo.Order;
import com.wingchi.order.pojo.OrderDTO;
import com.wingchi.order.pojo.OrderDetailDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ExampleTest {
    @Autowired
    OrderMapper orderMapper;
    @Test
    public void insert() {
        List<OrderDTO> orderD = orderMapper.getOrderByUserId(28L);
        for (OrderDTO orderDTO : orderD) {
            System.out.println(orderDTO);
        }
    }
}
