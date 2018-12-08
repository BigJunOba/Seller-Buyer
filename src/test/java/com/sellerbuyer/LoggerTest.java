package com.sellerbuyer;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @program: sell
 * @description: 日志测试
 * @author: JunOba
 * @create: 2018-12-08 16:41
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LoggerTest {

//    private final Logger logger = LoggerFactory.getLogger(LoggerTest.class);


    @Test
    public void test1() {
        String name = "root";
        String password = "123456";
        log.debug("debug...");
        log.info("name:{}, password:{}", name, password);
        log.error("error...");
        log.warn("warning");
    }
}
