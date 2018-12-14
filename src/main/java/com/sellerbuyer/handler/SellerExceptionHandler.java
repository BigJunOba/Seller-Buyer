package com.sellerbuyer.handler;

import com.sellerbuyer.ViewObject.ResultVO;
import com.sellerbuyer.config.ProjectUrlConfig;
import com.sellerbuyer.exception.ResponseBankException;
import com.sellerbuyer.exception.SellException;
import com.sellerbuyer.exception.SellerAuthorizeException;
import com.sellerbuyer.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
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

    @ExceptionHandler(value = SellException.class)
    @ResponseBody
    public ResultVO handlerSellerException(SellException e) {
        return ResultVOUtil.error(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(value = ResponseBankException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public void handlerResponseBankException() {

    }
}
