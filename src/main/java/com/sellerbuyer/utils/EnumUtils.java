package com.sellerbuyer.utils;

import com.sellerbuyer.enums.CodeEnum;

/**
 * @program: sell
 * @description: 获取Code工具类
 * @author: JunOba
 * @create: 2018-12-12 17:34
 */
public class EnumUtils {

    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass) {
        for (T each : enumClass.getEnumConstants()) {
            if (code.equals(each.getCode())) {
                return each;
            }
        }
        return null;
    }
}
