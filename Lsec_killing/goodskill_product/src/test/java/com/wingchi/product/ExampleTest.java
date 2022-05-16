package com.wingchi.product;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wingchi.product.beans.Image;
import com.wingchi.product.mapper.ImageMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ExampleTest {
    @Autowired
    ImageMapper imageMapper;

    @Test
    public void mapperTest() {
        ArrayList<Image> images = imageMapper.selectCarousel();
        images.forEach(System.out::println);
    }

//    @Test
    public void whenJson_thanConvertToObjectCorrect() {
        String json= "['洗衣机','空调','电视']";
        JSONArray jsonArray = JSON.parseArray(json) ;
        jsonArray.forEach(System.out::println);

        List<String> list = JSONObject.parseArray(jsonArray.toJSONString(),String.class) ;
        list.forEach(System.out::println);
    }

}
