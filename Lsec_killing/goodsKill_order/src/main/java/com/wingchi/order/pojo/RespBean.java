package com.wingchi.order.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class RespBean {
    String code ;
    String msg ;
    Object data ;

    public RespBean(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
