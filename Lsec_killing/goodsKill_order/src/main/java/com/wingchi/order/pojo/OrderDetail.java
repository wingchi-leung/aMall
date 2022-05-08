package com.wingchi.order.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
public class OrderDetail {
    Long id ;
    Long orderId;
    Long skuId;
    Integer num ;
    String title;
    Double price;
    String image;
    Timestamp createTime;
    Timestamp updateTime;

    public OrderDetail( Long orderId, Long skuId, Integer num, String title, Double price, String image) {
        this.orderId = orderId;
        this.skuId = skuId;
        this.num = num;
        this.title = title;
        this.price = price;
        this.image = image;
    }
}
