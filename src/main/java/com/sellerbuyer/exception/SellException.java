package com.sellerbuyer.exception;

import com.sellerbuyer.enums.ResultEnum;

/**
 * @program: sell
 * @description: 异常类
 * @author: JunOba
 * @create: 2018-12-10 08:46
 */
public class SellException extends RuntimeException {

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }
}
