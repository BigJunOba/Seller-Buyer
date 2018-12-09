package com.sellerbuyer.service;

import com.sellerbuyer.dataobject.ProductCategory;

import java.util.List;

/**
 * @program: sell
 * @description: 商品类目Service接口
 * @author: JunOba
 * @create: 2018-12-09 15:50
 */
public interface CategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}
