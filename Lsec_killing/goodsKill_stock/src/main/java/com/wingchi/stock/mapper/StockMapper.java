package com.wingchi.stock.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StockMapper {
    Integer getStockBySkuId(Long skuId) ;
}
