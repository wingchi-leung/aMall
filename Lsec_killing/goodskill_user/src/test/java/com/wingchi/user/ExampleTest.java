package com.wingchi.user;

import com.wingchi.user.bean.User;
import com.wingchi.user.mapper.ShoppingCartMapper;
import com.wingchi.user.mapper.UserMapper;
import com.wingchi.user.service.UserService;
import com.wingchi.user.vo.ShoppingCart;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = UserApplication.class)
@RunWith(SpringRunner.class)
public class ExampleTest {
    @Autowired
    UserMapper userMapper ;
    @Autowired
    UserService userService ;

    @Autowired
    ShoppingCartMapper cartMapper;
    @Test
    public void MapperTest() {
        ArrayList<String> roleById = userMapper.getRoleById(32L);
        roleById.forEach(System.out::println);
    }

    @Test
    public void password(){
        BCryptPasswordEncoder encoder =new BCryptPasswordEncoder();
        System.out.println(encoder.encode("123000"));
    }
    @Test
    public void sqlTest(){
        List<ShoppingCart> Carts = cartMapper.selectCartById(28L);
        for (ShoppingCart cart : Carts) {
            System.out.println(cart.toString());
        }
    }
}
