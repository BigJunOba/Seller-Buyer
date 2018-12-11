package com.sellerbuyer.utils;

/**
 * @program: sell
 * @description: 判断金额是否相等
 * @author: JunOba
 * @create: 2018-12-11 21:40
 */
public class MathUtil {

    private static final Double MONEY_RANGE = 0.01;
    public static Boolean equals(Double d1, Double d2) {
        Double result = Math.abs(d1 - d2);
        if (result < MONEY_RANGE) {
            return true;
        } else {
            return false;
        }
    }
}
