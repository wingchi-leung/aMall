package com.wingchi.stock.service;

import com.wingchi.stock.mapper.StockMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockService {

    @Autowired
    StockMapper stockMapper;
    public Integer getStockByskuId(Long skuId) {
        return stockMapper.getStockBySkuId(skuId);
    }
}
