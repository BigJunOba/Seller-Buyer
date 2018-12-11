package com.sellerbuyer.service;

import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundResponse;
import com.sellerbuyer.dto.OrderDTO;

/**
 * @program: sell
 * @description: 微信支付
 * @author: JunOba
 * @create: 2018-12-11 16:04
 */
public interface PayService {

    PayResponse create(OrderDTO orderDTO);

    PayResponse notify(String notifyData);

    RefundResponse refund(OrderDTO orderDTO);
}
