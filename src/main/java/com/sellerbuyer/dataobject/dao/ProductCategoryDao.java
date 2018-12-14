package com.sellerbuyer.dataobject.dao;

import com.sellerbuyer.dataobject.mapper.ProductCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * @program: sell
 * @description: 商品类目dao
 * @author: JunOba
 * @create: 2018-12-14 15:23
 */
public class ProductCategoryDao {

    @Autowired
    ProductCategoryMapper mapper;

    public int insertByMap(Map<String, Object> map) throws Exception {
        return mapper.insertByMap(map);
    }
}
