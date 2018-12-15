package com.sellerbuyer.ViewObject;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: sell
 * @description: Http请求返回的最外层对象
 * @author: JunOba
 * @create: 2018-12-09 17:46
 */
@Data
public class ResultVO<T> implements Serializable {

    private static final long serialVersionUID = 2078919375327690989L;

    /** 错误码 */
    private Integer code;

    /** 提示信息 */
    private String msg;

    /** 具体内容 */
    private T data;
}
