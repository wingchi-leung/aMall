package com.wingchi.user.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigInteger;

@Data
@AllArgsConstructor
public class Role {
    String RoleName ;
    BigInteger  id ;

    public Role(String roleName) {
        RoleName = roleName;
    }
}
