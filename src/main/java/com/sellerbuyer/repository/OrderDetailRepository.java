package com.sellerbuyer.repository;

import com.sellerbuyer.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: sell
 * @description: 订单详情表DAO
 * @author: JunOba
 * @create: 2018-12-09 22:01
 */
@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {

    List<OrderDetail> findByOrOrderId(String orderId);
}
