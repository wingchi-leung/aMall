package com.wingchi.product.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wingchi.product.beans.Image;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;
import java.util.List;

public interface ImageMapper extends BaseMapper<Image> {

    //查询轮播图
    @Select("select *from  image where category = 'cms' ")
    ArrayList<Image> selectCarousel() ;


//    根据类别名称查找商品主图，用在首页。
    ArrayList<Image> selectMainByCategory(@Param("category") String category) ;

//    根据SkuID查找图片，非主图。
    List<Image> selectByID(Long productId);
}
