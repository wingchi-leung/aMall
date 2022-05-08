package com.wingchi.order.pojo;

import lombok.Data;
import lombok.ToString;

import java.sql.Timestamp;
import java.util.List;

@Data
@ToString
public class OrderDTO {
    List<OrderDetailDTO> cartList;
    Long userId;
    Long orderId;
    Double totalPrice;
    Timestamp orderTime;

}
