package com.sellerbuyer.utils;

import java.util.Random;

/**
 * @program: sell
 * @description: 生成随机数的数据库id
 * @author: JunOba
 * @create: 2018-12-10 09:02
 */
public class KeyUtil {
    /**
    * @Description:生成唯一的主键，需要加同步关键字
    * @格式: 时间+随机数
    * @Author: JunOba
    * @Date: 2018/12/10
    */
    public static synchronized String genUniqueKey() {
        Random random = new Random();
        // 生成六位随机数
        Integer number = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(number);
    }
}
