package com.sellerbuyer.service.Impl;

import com.sellerbuyer.dataobject.ProductCategory;
import com.sellerbuyer.dataobject.dao.ProductCategoryDao;
import com.sellerbuyer.repository.ProductCategoryRepository;
import com.sellerbuyer.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: sell
 * @description: 商品Service实现
 * @author: JunOba
 * @create: 2018-12-09 15:53
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ProductCategoryRepository repository;

    @Override
    public ProductCategory findOne(Integer categoryId) {
        return repository.findOne(categoryId);
    }

    @Override
    public List<ProductCategory> findAll() {
        return repository.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return repository.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return repository.save(productCategory);
    }
}
