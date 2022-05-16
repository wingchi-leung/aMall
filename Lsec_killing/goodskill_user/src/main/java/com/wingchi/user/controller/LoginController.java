package com.wingchi.user.controller;


import com.wingchi.user.bean.RespBean;
import com.wingchi.user.bean.User;
import com.wingchi.user.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class LoginController {
    @Autowired
    private LoginService loginService ;

    @PostMapping(value = {"/login","/"})
    public RespBean login(@RequestBody User user ) {
        RespBean respBean = loginService.login(user);
        return respBean;
    }

    @RequestMapping(value = "/logut")
    public RespBean logout(){
        return loginService.logout();
    }
}
