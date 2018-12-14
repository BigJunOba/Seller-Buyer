package com.sellerbuyer.service;

import com.sellerbuyer.dto.OrderDTO;

/**
 * @program: sell
 * @description: 模板消息
 * @author: JunOba
 * @create: 2018-12-13 22:18
 */
public interface PushMessageService {

    /**
     * 订单状态变更消息
     * @param orderDTO
     */
    void orderStatus(OrderDTO orderDTO);
}
