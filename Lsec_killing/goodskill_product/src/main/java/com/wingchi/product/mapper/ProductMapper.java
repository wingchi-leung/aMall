package com.wingchi.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wingchi.product.beans.SKU;

import java.util.List;

public interface ProductMapper extends BaseMapper<SKU> {

    List<SKU> selectAllBycategory(String category);

    List<SKU> selectAllByAllcategory(List<Object> categoryList);
}
