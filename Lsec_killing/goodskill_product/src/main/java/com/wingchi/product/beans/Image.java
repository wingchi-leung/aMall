package com.wingchi.product.beans;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@TableName("image")
@ToString
public class Image {
    String url ;
    String name ;
    String category ;
}
