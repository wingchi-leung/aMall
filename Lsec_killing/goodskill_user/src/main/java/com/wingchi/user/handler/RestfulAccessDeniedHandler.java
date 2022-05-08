package com.wingchi.user.handler;

import com.alibaba.fastjson.JSON;
import com.wingchi.user.bean.RespBean;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class RestfulAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse Response, AccessDeniedException e) throws IOException, ServletException {
        RespBean re= new RespBean(HttpStatus.FORBIDDEN.toString(), "权限不足!") ;
        // 将对象序列化成JSON字符串
        String json = JSON.toJSONString(re);
        Response.setContentType("application/json");
        Response.setCharacterEncoding("UTF-8");
        Response.getWriter().print(json);
        Response.getWriter().flush() ;

    }
}
