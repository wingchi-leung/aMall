package com.wingchi.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wingchi.user.bean.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

public interface UserMapper extends BaseMapper<User> {
    @Select("select *from user where username=#{username}")
    User getUserByName(@Param("username") String Name) ;

    @Select("select name,description,role_user.user_id\n" +
            "from role,role_user,user\n" +
            "where user.id=32 and user.id=role_user.user_id and role.id=role_user.role_id ; " )
    ArrayList<String> getRoleById(@Param("user_id") Long id);
}
