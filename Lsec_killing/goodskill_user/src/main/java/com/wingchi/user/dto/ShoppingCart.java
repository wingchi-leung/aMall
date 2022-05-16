package com.wingchi.user.dto;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ShoppingCart {
    Long Id;
    Long skuId;
    String name;
    String images;
    Double price ;
    Integer amount;
    Boolean check;
}
