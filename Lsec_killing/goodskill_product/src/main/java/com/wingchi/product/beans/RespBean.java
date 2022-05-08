package com.wingchi.product.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RespBean {
    Object data;
    String code ;
    String msg;

    public RespBean (Object data, String code) {
        this.data=data;
        this.code=code;
    }
    public RespBean fail(Object data ) {
        return new RespBean(data, "1000", "fail");
    }

}
