package com.wingchi.user.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.Map;

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
