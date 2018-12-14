package com.sellerbuyer.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @program: sell
 * @description: Redis分布式锁
 * @author: JunOba
 * @create: 2018-12-14 17:03
 */
@Component
@Slf4j
public class RedisLock {

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
    * @Description: 加锁
    * @param key productId
    * @param value 当前时间+Redis的键的过期时间
    * @return:
    * @Author: JunOba
    * @Date: 2018/12/14
    */
    public boolean lock(String key, String value) {
        if (redisTemplate.opsForValue().setIfAbsent(key, value)) {
            return true;
        }
        String currentValue = redisTemplate.opsForValue().get(key);
        // 如果锁过期
        if (!StringUtils.isEmpty(currentValue) && Long.parseLong(currentValue) < System.currentTimeMillis()) {
            // 获取上一个锁的时间
            String oldValue = redisTemplate.opsForValue().getAndSet(key, value);
            if (!StringUtils.isEmpty(oldValue) && oldValue.equals(currentValue)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @Description: 解锁
     * @param key productId
     * @param value 当前时间+Redis的键的过期时间
     * @Author: JunOba
     * @Date: 2018/12/14
     */
    public void unlock(String key, String value) {
        String currentValue = redisTemplate.opsForValue().get(key);
        if (!StringUtils.isEmpty(currentValue) && currentValue.equals(value)) {
            try {
                redisTemplate.opsForValue().getOperations().delete(key);
            } catch (Exception e) {
                log.error("[Redis分布式锁] 解锁异常，{}", e);
            }
        }
    }
}
