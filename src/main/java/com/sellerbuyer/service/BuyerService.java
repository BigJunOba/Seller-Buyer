package com.sellerbuyer.service;

import com.sellerbuyer.dto.OrderDTO;

/**
 * @program: sell
 * @description: 买家Service
 * @author: JunOba
 * @create: 2018-12-10 17:08
 */
public interface BuyerService {

    // 查询一个订单
    OrderDTO findOrderOne(String openid, String orderid);

    // 取消订单
    OrderDTO cancelOrder(String openid, String orderid);
}
