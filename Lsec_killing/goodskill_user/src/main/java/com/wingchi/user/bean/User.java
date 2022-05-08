package com.wingchi.user.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@ToString
public class User implements UserDetails {
    @TableId
    private Long id;
    private String username;
    private String password;
    private String phone;
    private Timestamp createTime;
    private Timestamp updateTime;
    private boolean enable ;
    @TableField(exist = false)
    List<Role> roleList;

    public void setRoleList(List<String>  list) {
        roleList=new ArrayList<>();
        for(String str : list ){
            roleList.add(new Role(str)) ;
        }
    }

    //TODO 序列化问题。
    @TableField(exist = false)
    ArrayList<SimpleGrantedAuthority> authoritiesList;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(authoritiesList==null){
            authoritiesList= new ArrayList<>() ;
            for (Role role : roleList){
                authoritiesList.add(new SimpleGrantedAuthority(role.getRoleName())) ;
            }
        }
        return authoritiesList;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
