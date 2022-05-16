package com.wingchi.user.service;

import com.wingchi.user.bean.RespBean;
import com.wingchi.user.bean.User;
import com.wingchi.user.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class LoginService {

    @Autowired
    private AuthenticationManager authenticationManager ;

    public RespBean login(User user) {
//      authenticationManager调用authenticate方法进行认证
        Authentication authenticate = authenticationManager.
                authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        if(Objects.isNull(authenticate)){
            throw new RuntimeException("认证失败!");
        }
//      获取登录的用户
        User loginUser = (User) authenticate.getPrincipal();
        String jwt = JwtUtil.createJWT(loginUser.getUsername(),String.valueOf(loginUser.getId()));
        Map<String,Object> map =new HashMap<>();
        map.put("token",jwt);
        map.put("userName",loginUser.getUsername()) ;
        map.put("userId",loginUser.getId());
//        返回给json数据给前端。
        return new RespBean("001","登录成功",map);
    }

    public RespBean logout() {
        //获取SecurityContextHolder的用户信息
        UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        User user = (User)authentication.getPrincipal();
        Long id = user.getId();

        return null ;
    }



}
