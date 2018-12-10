package com.sellerbuyer.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sellerbuyer.dataobject.OrderDetail;
import com.sellerbuyer.enums.OrderStatusEnum;
import com.sellerbuyer.enums.PayStatusEnum;
import com.sellerbuyer.utils.serializer.Data2LongSerializer;
import lombok.Data;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program: sell
 * @description: OrderMaster订单传输对象，订单总表一个id对应订单详情表多个商品
 * @author: JunOba
 * @create: 2018-12-10 08:34
 */
@Data
//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {

    /** 订单id */
    private String orderId;

    /** 买家名字 */
    private String buyerName;

    /** 买家手机号 */
    private String buyerPhone;

    /** 买家地址 */
    private String buyerAddress;

    /** 买家微信Openid */
    private String buyerOpenid;

    /** 订单总金额 */
    private BigDecimal orderAmount;

    /** 订单状态, 默认为0新下单 */
    private Integer orderStatus;

    /** 支付状态, 默认为0未支付 */
    private Integer payStatus;

    /** 创建时间 */
    @JsonSerialize(using = Data2LongSerializer.class)
    private Date createTime;

    /** 更新时间 */
    @JsonSerialize(using = Data2LongSerializer.class)
    private Date updateTime;

    private List<OrderDetail> orderDetailList;
}