package com.sellerbuyer.service.Impl;

import com.sellerbuyer.dto.OrderDTO;
import com.sellerbuyer.enums.ResultEnum;
import com.sellerbuyer.exception.SellException;
import com.sellerbuyer.service.BuyerService;
import com.sellerbuyer.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: sell
 * @description: 买家取消订单和查找一个订单实现
 * @author: JunOba
 * @create: 2018-12-10 17:10
 */
@Service
@Slf4j
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    private OrderService orderService;

    @Override
    public OrderDTO findOrderOne(String openid, String orderid) {
        return checkOrderOwner(openid, orderid);
    }

    @Override
    public OrderDTO cancelOrder(String openid, String orderid) {
        OrderDTO orderDTO = checkOrderOwner(openid, orderid);
        if (orderDTO == null) {
            log.error("[取消订单] 查不到该订单，orderid={}", orderid);
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        return orderService.cancel(orderDTO);
    }

    private OrderDTO checkOrderOwner(String openid, String orderid) {
        OrderDTO orderDTO = orderService.findOne(orderid);
        if (orderDTO == null) {
            return null;
        }
        // 判断是否是自己的订单
        if (!orderDTO.getBuyerOpenid().equalsIgnoreCase(openid)) {
            log.error("[查询订单] 订单的openid不一致. openid={}, orderDTO={}", openid, orderDTO);
            throw new SellException(ResultEnum.ORDER_OWNER_ERROR);
        }
        return orderDTO;
    }
}
