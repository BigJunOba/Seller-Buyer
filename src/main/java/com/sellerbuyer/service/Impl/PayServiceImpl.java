package com.sellerbuyer.service.Impl;

import com.lly835.bestpay.enums.BestPayTypeEnum;
import com.lly835.bestpay.model.PayRequest;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundRequest;
import com.lly835.bestpay.model.RefundResponse;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import com.sellerbuyer.dto.OrderDTO;
import com.sellerbuyer.enums.ResultEnum;
import com.sellerbuyer.exception.SellException;
import com.sellerbuyer.service.OrderService;
import com.sellerbuyer.service.PayService;
import com.sellerbuyer.utils.MathUtil;
import com.sellerbuyer.utils.serializer.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @program: sell
 * @description: 支付
 * @author: JunOba
 * @create: 2018-12-11 16:05
 */
@Service
@Slf4j
public class PayServiceImpl implements PayService {

    private static final String ORDER_NAME = "微信点餐订单";

    @Autowired
    private BestPayServiceImpl bestPayService;

    @Autowired
    private OrderService orderService;

    @Override
    public PayResponse create(OrderDTO orderDTO) {
        PayRequest payRequest = new PayRequest();
        payRequest.setOrderId(orderDTO.getOrderId());
        payRequest.setOpenid(orderDTO.getBuyerOpenid());
        payRequest.setOrderAmount(orderDTO.getOrderAmount().doubleValue());
        payRequest.setOrderName(ORDER_NAME);
        payRequest.setPayTypeEnum(BestPayTypeEnum.WXPAY_H5);
        log.info("[微信支付 发起支付 request]={}", JsonUtil.toJson(payRequest));

        PayResponse payResponse = bestPayService.pay(payRequest);
        log.info("[微信支付 发起支付 response]={}", JsonUtil.toJson(payResponse));
        return payResponse;
    }

    @Override
    public PayResponse notify(String notifyData) {
        // 1.验证签名（bestPayService已做）
        // 2.支付的状态（bestPayService已做）
        // 3.支付的金额
        // 4.支付人（下单人 == 支付人）
        PayResponse payResponse = bestPayService.asyncNotify(notifyData);
        log.info("[微信支付] 异步通知， payResponse={}", JsonUtil.toJson(payResponse));
        // 查询订单
        OrderDTO orderDTO = orderService.findOne(payResponse.getOrderId());
        // 判断订单是否存在
        if (orderDTO == null) {
            log.error("[微信支付] 异步通知，订单不存在，orderId={}", payResponse.getOrderId());
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        // 判断金额是否一致（0.10 和 0.1   0.01 和 0.010000000000000000000012323123）
        if (!MathUtil.equals(payResponse.getOrderAmount(), orderDTO.getOrderAmount().doubleValue())) {
            log.error("[微信支付] 异步通知，订单金额不一致，orderId={}，微信通知金额={}，系统金额={}",
                    payResponse.getOrderId(), payResponse.getOrderAmount(), orderDTO.getOrderAmount());
            throw new SellException(ResultEnum.WXPAY_NOTIFY_MONRY_VERIFY_ERROR);
        }
        // 修改订单的支付状态
        orderService.paid(orderDTO);
        return payResponse;
    }

    @Override
    public RefundResponse refund(OrderDTO orderDTO) {
        RefundRequest refundRequest = new RefundRequest();
        refundRequest.setOrderId(orderDTO.getOrderId());
        refundRequest.setOrderAmount(orderDTO.getOrderAmount().doubleValue());
        refundRequest.setPayTypeEnum(BestPayTypeEnum.WXPAY_H5);
        log.error("[微信退款] refundRequest={}", JsonUtil.toJson(refundRequest));

        RefundResponse refundResponse = bestPayService.refund(refundRequest);
        log.error("[微信退款] refundResponse={}", JsonUtil.toJson(refundResponse));

        return refundResponse;
    }
}
