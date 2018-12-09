package com.sellerbuyer.enums;

import lombok.Getter;

/**
 * @program: sell
 * @description: 支付状态
 * @author: JunOba
 * @create: 2018-12-09 21:44
 */
@Getter
public enum PayStatusEnum {

    WAIT(0, "等待支付"),
    SUCCESS(1, "支付成功"),
    ;

    private Integer code;

    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
