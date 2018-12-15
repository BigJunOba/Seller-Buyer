package com.sellerbuyer.ViewObject;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @program: sell
 * @description: 商品详情，即food里面的内容
 * @author: JunOba
 * @create: 2018-12-09 19:32
 */
@Data
public class ProductInfoVO implements Serializable {

    private static final long serialVersionUID = -7241784035657833418L;

    @JsonProperty("id")
    private String productId;

    @JsonProperty("name")
    private String productName;

    @JsonProperty("price")
    private BigDecimal productPrice;

    @JsonProperty("description")
    private String productDescription;

    @JsonProperty("icon")
    private String productIcon;
}
