package com.wingchi.user.controller;

import com.wingchi.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/hello")
    public String Hello(){
        return "hello,you are great!" ;
    }

    @GetMapping("/shop")
    @PreAuthorize("hasAuthority('store_manager')")
    public String StoreManager(){
        return "你是店家！";
    }
}
