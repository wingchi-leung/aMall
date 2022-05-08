package com.wingchi.user.handler;

import com.alibaba.fastjson.JSON;
import com.wingchi.user.bean.RespBean;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse Response, AuthenticationException e) throws IOException, ServletException {
        RespBean re= new RespBean(HttpStatus.UNAUTHORIZED.toString(), "登录失败，请重试") ;
        // 将对象序列化成JSON字符串
        String json = JSON.toJSONString(re);
        Response.setContentType("application/json");
        Response.setCharacterEncoding("UTF-8");
        Response.setStatus(200);
        Response.getWriter().print(json);
        Response.getWriter().flush() ;


    }
}
