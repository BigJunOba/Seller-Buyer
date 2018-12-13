package com.sellerbuyer.form;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @program: sell
 * @description: 表单提交过来的字段
 * @author: JunOba
 * @create: 2018-12-13 10:54
 */
@Data
public class ProductForm {

    private String productId;

    /** 商品名字. */
    private String productName;

    /** 商品单价. */
    private BigDecimal productPrice;

    /** 商品库存. */
    private Integer productStock;

    /** 商品描述. */
    private String productDescription;

    /** 商品小图. */
    private String productIcon;

    /** 商品类目编号. */
    private Integer categoryType;
}
