package com.wingchi.order.pojo;

import lombok.Data;

import java.math.BigInteger;

@Data
public class OrderDetailDTO {
    Long Id;
    Long skuId;
    String skuName;
    String skuImage;
    Double price ;
    Integer amount;
    Boolean check;
}
