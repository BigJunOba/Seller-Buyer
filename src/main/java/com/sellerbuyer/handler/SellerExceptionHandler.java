package com.sellerbuyer.handler;

import com.sellerbuyer.config.ProjectUrlConfig;
import com.sellerbuyer.exception.SellerAuthorizeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @program: sell
 * @description: 异常处理
 * @author: JunOba
 * @create: 2018-12-13 21:36
 */
@ControllerAdvice
public class SellerExceptionHandler {

    @Autowired
    private ProjectUrlConfig projectUrlConfig;

    // 拦截登录异常
    // 扫码登录Url : "http://junoba.nat100.top/sell/wechat/qrAuthorize?returnUrl=http://junoba.nat100.top/sell/seller/login"
    @ExceptionHandler(value = SellerAuthorizeException.class)
    public ModelAndView handlerAuthorizeException() {
        return new ModelAndView("redirect:"
                .concat(projectUrlConfig.getWechatOpenAuthorize())
                .concat("/sell/wechat/qrAuthorize")
                .concat("?returnUrl=")
                .concat(projectUrlConfig.getSell())
                .concat("/sell/seller/login"));
    }
}
