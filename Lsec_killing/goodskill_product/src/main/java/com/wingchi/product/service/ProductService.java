package com.wingchi.product.service;

import com.wingchi.product.beans.Image;
import com.wingchi.product.beans.SKU;
import com.wingchi.product.mapper.ImageMapper;
import com.wingchi.product.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductMapper productMapper ;
    @Autowired
    ImageMapper imageMapper;


    // 根据单个类别名称查找一组商品
    public List<SKU> getProductsByCategory(String category) {
        List<SKU> list=   productMapper.selectAllBycategory(category) ;
        return list;
    }

    //根据一组类别名称查找一组商品
    public List<SKU> getProductsByCategory(List<Object>   categoryList) {
        return productMapper.selectAllByAllcategory(categoryList) ;
    }

    //根据SkuID查找某个商品
    public SKU getProductByID(Long productId) {
        return productMapper.selectByskuId(productId) ;
    }

    public void getSeckillProduct() {
        productMapper.selectSeckill() ;
    }
}
