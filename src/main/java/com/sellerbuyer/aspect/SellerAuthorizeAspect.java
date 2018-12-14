package com.sellerbuyer.aspect;

import com.sellerbuyer.constant.CookieConstant;
import com.sellerbuyer.constant.RedisConstant;
import com.sellerbuyer.exception.SellException;
import com.sellerbuyer.exception.SellerAuthorizeException;
import com.sellerbuyer.utils.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @program: sell
 * @description: 卖家授权
 * @author: JunOba
 * @create: 2018-12-13 21:23
 */
@Aspect
@Component
@Slf4j
public class SellerAuthorizeAspect {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Pointcut("execution(public * com.sellerbuyer.controller.Seller*.*(..))" +
    "&& !execution(public * com.sellerbuyer.controller.SellerUserController.*(..))")
    public void verify() {};

    @Before("verify()")
    public void doVerify() {
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 查询Cookie
        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);
        if (cookie == null) {
            log.warn("[登录校验] Cookie中查不到token");
            throw new SellerAuthorizeException();
        }

        // 查询Redis
        String tokenValue = redisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_PREFIX, cookie.getValue()));
        if (StringUtils.isEmpty(tokenValue)) {
            log.warn("[登录校验] Redis中查不到token");
            throw new SellerAuthorizeException();
        }
    }
}
