package com.sellerbuyer.service;

import com.sellerbuyer.dataobject.SellerInfo;
import org.springframework.stereotype.Service;

/**
 * @program: sell
 * @description: 卖家端Service
 * @author: JunOba
 * @create: 2018-12-13 15:46
 */
public interface SellerService {

    /**
    * @Description: 通过openid查询卖家信息
    * @param openid 微信openid
    * @return: 卖家端信息
    * @Author: JunOba
    * @Date: 2018/12/13
    */
    SellerInfo findSellerInfoByOpenid(String openid);
}
