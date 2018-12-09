package com.sellerbuyer.utils;

import com.sellerbuyer.ViewObject.ResultVO;

/**
 * @program: sell
 * @description: 处理http返回类ResultVO的工具类
 * @author: JunOba
 * @create: 2018-12-09 20:15
 */
public class ResultVOUtil {

    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }

    public static ResultVO success() {
        return success(null);
    }

    public static ResultVO error(Integer code, String msg) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }
}
