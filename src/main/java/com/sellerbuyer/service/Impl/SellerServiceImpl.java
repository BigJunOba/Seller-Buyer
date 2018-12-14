package com.sellerbuyer.service.Impl;

import com.sellerbuyer.dataobject.SellerInfo;
import com.sellerbuyer.repository.SellerInfoRepository;
import com.sellerbuyer.service.SellerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: sell
 * @description: 卖家端Service
 * @author: JunOba
 * @create: 2018-12-13 15:47
 */
@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerInfoRepository repository;

    @Override
    public SellerInfo findSellerInfoByOpenid(String openid) {
        return repository.findByOpenid(openid);
    }
}
