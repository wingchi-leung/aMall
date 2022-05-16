package com.wingchi.user.config;

import com.wingchi.user.filter.JwtAuthenticateFilter;
import com.wingchi.user.handler.RestAuthenticationEntryPoint;
import com.wingchi.user.handler.RestfulAccessDeniedHandler;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private JwtAuthenticateFilter jwtAuthenticateFilter;

    @Autowired
    private RestfulAccessDeniedHandler accessDeniedHandler;

    @Autowired
    private RestAuthenticationEntryPoint entryPoint;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf()// 使用的是JWT,不需要csrf
                .disable()
                .sessionManagement()// 基于token，所以不需要session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(
                        "/",
                        "/*.html",
                        "/**/*.html",
                        "/**/*.css",
                        "/**/*.js"
                )
                .permitAll()
                .antMatchers("/user/login", "/user/register","/user/hello")
                .anonymous()// 对登录注册要允许匿名访问
                .anyRequest()// 除上面外的所有请求全部需要鉴权认证
                .authenticated();
        //添加jwt过滤器,放在UsernamePasswordAuthenticationFilter前面
        httpSecurity.addFilterBefore(jwtAuthenticateFilter, UsernamePasswordAuthenticationFilter.class);
        //配置异常处理器
//        httpSecurity.exceptionHandling().authenticationEntryPoint()
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }



    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder (){
        return new BCryptPasswordEncoder();
    }
}
