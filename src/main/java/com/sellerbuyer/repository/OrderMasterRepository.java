package com.sellerbuyer.repository;

import com.sellerbuyer.dataobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @program: sell
 * @description: 商品主表DAO层
 * @author: JunOba
 * @create: 2018-12-09 21:59
 */
@Repository
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {

    Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);
}
