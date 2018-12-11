package com.sellerbuyer.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.net.ssl.SSLContext;

/**
 * @program: sell
 * @description: 账号相关
 * @author: JunOba
 * @create: 2018-12-10 22:33
 */
@Data
@Component
@ConfigurationProperties(prefix = "wechat")
public class WechatAccountConfig {

    private String mpAppId;

    private String mpAppSecret;

    /**
     *  商户号
     */
    private String mchId;

    /**
     *  商户密钥
     */
    private String mchKey;

    /**
     *  商户证书路径
     */
    private String keyPath;

    /**
     * 微信支付异步通知地址
     */
    private String notifyUrl;

}
