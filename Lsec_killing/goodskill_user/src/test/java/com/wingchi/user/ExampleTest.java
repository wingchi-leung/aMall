package com.wingchi.user;

import com.wingchi.user.service.ShoppingCartService;
import com.wingchi.user.dto.ShoppingCart;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = UserApplication.class)
@RunWith(SpringRunner.class)
public class ExampleTest {

    @Autowired
    ShoppingCartService cartService ;
//    @Test
    public void cartTest(){
        ShoppingCart cart=new ShoppingCart();
        cart.setAmount(1);
        cart.setPrice(2599.9);
        cart.setName("小米9032");
        cart.setSkuId(2735902125L);
        cartService.addProduct(cart,28L) ;
    }
}
