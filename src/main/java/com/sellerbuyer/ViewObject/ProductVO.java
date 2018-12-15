package com.sellerbuyer.ViewObject;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @program: sell
 * @description: Http请求的data字段，即商品(包含类目)
 * @author: JunOba
 * @create: 2018-12-09 19:28
 */
@Data
public class ProductVO implements Serializable {

    private static final long serialVersionUID = -6937511356305596370L;

    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    // 只是ProductInfo对象的部分字段，例如库存，上下架状态之类的不返回
    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;

}
