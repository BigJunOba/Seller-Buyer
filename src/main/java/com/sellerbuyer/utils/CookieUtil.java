package com.sellerbuyer.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: sell
 * @description: 写Cookie到reponse中
 * @author: JunOba
 * @create: 2018-12-13 20:34
 */
public class CookieUtil {

    /**
    * @Description: 设置cookie到reponse中
    * @param
    * @return:
    * @Author: JunOba
    * @Date: 2018/12/13
    */
    public static void set(HttpServletResponse response, String name, String value, int maxAge) {
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        cookie.setMaxAge(maxAge);
        response.addCookie(cookie);
    }

    /**
    * @Description: 获取cookie
    * @param null
    * @return:
    * @Author: JunOba
    * @Date: 2018/12/13
    */
    public static Cookie get(HttpServletRequest request, String name) {
        Map<String, Cookie> cookieMap = readCookie(request);
        return cookieMap.getOrDefault(name, null);
    }

    /**
    * @Description: 将cookie数组封装成map
    * @param null
    * @return:
    * @Author: JunOba
    * @Date: 2018/12/13
    */
    private static Map<String, Cookie> readCookie(HttpServletRequest request) {
        Map<String, Cookie> cookieMap = new HashMap<>();
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                cookieMap.put(cookie.getName(), cookie);
            }
        }
        return cookieMap;
    }
}
