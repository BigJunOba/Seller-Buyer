package com.sellerbuyer.dto;

import lombok.Data;

/**
 * @program: sell
 * @description: 购物车
 * @author: JunOba
 * @create: 2018-12-10 09:18
 */
@Data
public class CartDTO {

    /** 商品id */
    private String productId;

    /** 商品数量 */
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
