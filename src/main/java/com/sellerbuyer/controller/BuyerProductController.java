package com.sellerbuyer.controller;

import com.sellerbuyer.ViewObject.ProductInfoVO;
import com.sellerbuyer.ViewObject.ProductVO;
import com.sellerbuyer.ViewObject.ResultVO;
import com.sellerbuyer.dataobject.ProductCategory;
import com.sellerbuyer.dataobject.ProductInfo;
import com.sellerbuyer.service.CategoryService;
import com.sellerbuyer.service.ProductService;
import com.sellerbuyer.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: sell
 * @description: 买家商品
 * @author: JunOba
 * @create: 2018-12-09 17:42
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
//    @Cacheable(cacheNames = "product", key = "123") // 加上缓存后，再次访问同一个url，直接从Redis中读，永远都不会进入该方法
    @Cacheable(cacheNames = "product", key = "123", unless = "#result.getCode() != 0") // 只有返回码为0，即返回正确时才缓存
    public ResultVO getList() {

        // 1.查询所有的商家商品(千万不能把数据库查询放到for循环里面)
        List<ProductInfo> productInfoList = productService.findUpAll();

        // 2.查询类目(一次性查询)(千万不能把数据库查询放到for循环里面)
        /**
        List<Integer> categoryTypeList = new ArrayList<>();
        // 传统方法
        for (ProductInfo productInfo : productInfoList) {
            categoryTypeList.add(productInfo.getCategoryType());
        }
        */
        // 精简方法(lambda表达式)
        List<Integer> categoryTypeList = productInfoList.stream().
                map(e -> e.getCategoryType()).
                collect(Collectors.toList());
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        // 3.数据拼装
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    // 将productInfo的值拷贝到productInfoVO
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);

            productVOList.add(productVO);
        }

        return ResultVOUtil.success(productVOList);
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "hello";
    }
}
