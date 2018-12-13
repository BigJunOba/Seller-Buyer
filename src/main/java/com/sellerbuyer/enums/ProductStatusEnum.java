package com.sellerbuyer.enums;

import lombok.Getter;

/**
 * @program: sell
 * @description: 商品状态(0 : 正常 1 : 下架)
 * @author: JunOba
 * @create: 2018-12-09 17:16
 */
@Getter
public enum ProductStatusEnum implements CodeEnum{

    UP(0, "在架"),
    DOWN(1,"下架")
    ;

    private Integer code;

    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
