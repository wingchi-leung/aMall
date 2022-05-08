package com.wingchi.user.service;

import com.wingchi.user.bean.User;
import com.wingchi.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.getUserByName(username);
        if(user==null) {
            throw new UsernameNotFoundException("用户不存在!");
        }
        ArrayList<String> list = userMapper.getRoleById(user.getId());
        user.setRoleList(list);
        return user;
    }

}
