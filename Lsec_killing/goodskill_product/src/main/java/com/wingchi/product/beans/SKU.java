package com.wingchi.product.beans;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigInteger;
import java.sql.Timestamp;

@TableName("sku")
@Data
public class SKU {
    Long skuId ;
    Long spuId;
    String name;
    String images ;
    String title;
    String description;
    Integer price;
    Integer sellingPrice;
    Integer stock ;
    Integer enable;
    String categoryName ;
    Timestamp createTime ;
    Timestamp updateTime ;
}
