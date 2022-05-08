package com.wingchi.order.pojo;

import com.wingchi.order.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Timestamp;

@Data
@ToString
@NoArgsConstructor
public class Order {
    Long id;
    Double totalFee;
    Double actualFee;
    Double postFee ;
    Long userId;
    Integer paymentType;
    Integer status ;
    Timestamp createTime ;
    Timestamp payTime;
    Timestamp consignTime;
    Timestamp endTime;
    Timestamp closeTime;
    Timestamp updateTime;
    Timestamp commentTime ;

    public Order( Double totalFee, Double actualFee, Double postFee, Long userId, Integer status,Integer paymentType) {
        this.totalFee = totalFee;
        this.actualFee = actualFee;
        this.postFee = postFee;
        this.userId = userId;
        this.status = status;
        this.paymentType=paymentType;
    }

}
