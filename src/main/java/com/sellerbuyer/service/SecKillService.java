package com.sellerbuyer.service;

/**
 * @program:
 * @description: 商品秒杀业务
 * @author: JunOba
 * @create: 2018-12-13 15:46
 */
public interface SecKillService {

    /**
     * 查询秒杀活动特价商品的信息
     * @param productId
     * @return
     */
    String querySecKillProductInfo(String productId);

    /**
     * 模拟不同用户秒杀同一商品的请求
     * @param productId
     * @return
     */
    void orderProductMockDiffUser(String productId);

}
