package com.sellerbuyer.utils.serializer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @program: sell
 * @description: 格式化成Json工具类
 * @author: JunOba
 * @create: 2018-12-11 16:48
 */
public class JsonUtil {

    public static String toJson(Object object) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(object);
    }
}
