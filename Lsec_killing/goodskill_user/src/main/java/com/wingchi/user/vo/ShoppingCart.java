package com.wingchi.user.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.ToString;

import java.math.BigInteger;

//sku.id,sku.name,sku.images,car.price,car.amount
@Data
@ToString
public class ShoppingCart {
    BigInteger Id;
    BigInteger skuId;
    String skuName;
    String skuImage;
    Double price ;
    Integer amount;
    Boolean check;
}
