package com.wingchi.user.filter;

import com.wingchi.user.bean.User;
import com.wingchi.user.mapper.UserMapper;
import com.wingchi.user.util.JwtUtil;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@Component
@Slf4j
public class JwtAuthenticateFilter extends OncePerRequestFilter {
    @Autowired
    UserMapper userMapper ;
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {

        String token = httpServletRequest.getHeader("token");
        if(!StringUtils.hasText(token)){
                filterChain.doFilter(httpServletRequest,httpServletResponse);
                return ;   //防止filterChain返回后又继续执行下面的代码
        }
        Claims claims = JwtUtil.getClaims(token) ;
        String userId = (String) claims.get("userId");  //获取之前放进jwt的字段
        if(userId!=null)  {
            // 判断redis数据库中有没有这个用户ID
            User user = userMapper.selectById(Integer.valueOf(userId));
            ArrayList<String> list = userMapper.getRoleById(user.getId());
            user.setRoleList(list);
            if(userId.equals(String.valueOf(user.getId()))){
                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(user,null,user.getAuthorities());
                //认证通过,把信息存进SecurityContextHolder
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }
}
