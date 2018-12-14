package com.sellerbuyer.dataobject.mapper;

import com.sellerbuyer.SellApplication;
import com.sellerbuyer.dataobject.ProductCategory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SellApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
public class ProductCategoryMapperTest {

    @Autowired
    private ProductCategoryMapper mapper;

    @Test
    public void insertByMap() throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("category_name","不好吃");
        map.put("category_type", 250);
        int result = mapper.insertByMap(map);
        Assert.assertEquals(1, result);
    }

    @Test
    public void insertByObject() throws Exception {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("大家都不喜欢");
        productCategory.setCategoryType(23);
        int result = mapper.insertByObject(productCategory);
        Assert.assertEquals(1, result);
    }

    @Test
    public void findByCategoryType() {
        ProductCategory productCategory = mapper.findByCategoryType(22);
        Assert.assertNotNull(productCategory);
    }

    @Test
    public void findByCategoryName() {
        List<ProductCategory> productCategoryList = mapper.findByCategoryName("男生最爱");
        Assert.assertNotEquals(0, productCategoryList.size());
    }

    @Test
    public void updateByCategoryType() {
        int result = mapper.updateByCategoryType("男生最爱", 23);
        Assert.assertEquals(1, result);
    }

    @Test
    public void updateByObject() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("大家都不喜欢");
        productCategory.setCategoryType(23);
        int result = mapper.updateByObject(productCategory);
        Assert.assertEquals(1, result);
    }

    @Test
    public void deleteByCategoryType() {
        int result = mapper.deleteByCategoryType(23);
        Assert.assertEquals(1, result);
    }

    @Test
    public void selectByCategoryType() {
        ProductCategory result = mapper.selectByCategoryType(100);
        assertNotNull(result);
    }

}