package com.sellerbuyer.dto;

import com.sellerbuyer.dataobject.OrderDetail;
import com.sellerbuyer.enums.OrderStatusEnum;
import com.sellerbuyer.enums.PayStatusEnum;
import lombok.Data;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @program: sell
 * @description: OrderMaster订单传输对象，订单总表一个id对应订单详情表多个商品
 * @author: JunOba
 * @create: 2018-12-10 08:34
 */
@Data
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
    private Date createTime;

    /** 更新时间 */
    private Date updateTime;

    private List<OrderDetail> orderDetailList;
}
