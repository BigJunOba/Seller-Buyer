package com.sellerbuyer.repository;

import com.sellerbuyer.dataobject.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program: sell
 * @description: 卖家信息
 * @author: JunOba
 * @create: 2018-12-13 15:35
 */
public interface SellerInfoRepository extends JpaRepository<SellerInfo, String> {

    SellerInfo findByOpenid(String openid);

}
