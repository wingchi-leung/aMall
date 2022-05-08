package com.wingchi.product.service;

import com.wingchi.product.beans.Image;
import com.wingchi.product.mapper.ImageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

// 获取图片
@Service
public class ImageService {

    @Autowired
    ImageMapper imageMapper ;

//    查找轮播图
    public  List<Image> Getcarousel() {
        return imageMapper.selectCarousel() ;
    }

    public List<Image> getDetailPicture(Long productId) {
        return imageMapper.selectByID(productId) ;
    }
}
