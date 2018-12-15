package com.sellerbuyer.dataobject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sellerbuyer.enums.ProductStatusEnum;
import com.sellerbuyer.utils.EnumUtils;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@DynamicUpdate
public class ProductInfo implements Serializable {

    private static final long serialVersionUID = 3672741291837325930L;

    @Id
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

    /** 商品状态, 0正常1下架. */
    private Integer productStatus = ProductStatusEnum.UP.getCode();

    /** 商品类目编号. */
    private Integer categoryType;

    /** 商品创建时间. */
    private Date createTime;

    /** 商品修改时间. */
    private Date updateTime;

    @JsonIgnore
    public ProductStatusEnum getProductStatusEnum() {
        return EnumUtils.getByCode(productStatus, ProductStatusEnum.class);
    }
}
