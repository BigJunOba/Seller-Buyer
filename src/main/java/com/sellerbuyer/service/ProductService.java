package com.sellerbuyer.service;

import com.sellerbuyer.dataobject.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: sell
 * @description: 商品信息接口
 * @author: JunOba
 * @create: 2018-12-09 17:10
 */
public interface ProductService {

    ProductInfo findOne(String productId);

    /**
    * @Description: 买家查询所有在架的商品列表
    * @Param:
    * @return:
    * @Author: JunOba
    * @Date: 2018/12/9
    */
    List<ProductInfo> findUpAll();

    /**
    * @Description: 卖家分页查询所有的商品
    * @Param:
    * @return:
    * @Author: JunOba
    * @Date: 2018/12/9
    */
    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    // 加库存

    // 减库存
}
