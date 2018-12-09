package com.sellerbuyer.ViewObject;

import lombok.Data;

/**
 * @program: sell
 * @description: Http请求返回的最外层对象
 * @author: JunOba
 * @create: 2018-12-09 17:46
 */
@Data
public class ResultVO<T> {

    /** 错误码 */
    private Integer code;

    /** 提示信息 */
    private String msg;

    /** 具体内容 */
    private T data;
}
