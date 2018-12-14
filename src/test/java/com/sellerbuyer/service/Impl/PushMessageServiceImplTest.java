package com.sellerbuyer.service.Impl;

import com.sellerbuyer.dto.OrderDTO;
import com.sellerbuyer.service.OrderService;
import com.sellerbuyer.service.PushMessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PushMessageServiceImplTest {

    @Autowired
    private PushMessageService pushMessageService;

    @Autowired
    private OrderService orderService;

    @Test
    public void orderStatus() {

        OrderDTO orderDTO = orderService.findOne("1544532371414502765");
        pushMessageService.orderStatus(orderDTO);
    }
}