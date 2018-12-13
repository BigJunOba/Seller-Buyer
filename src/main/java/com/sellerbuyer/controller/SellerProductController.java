package com.sellerbuyer.controller;

import com.sellerbuyer.dataobject.ProductInfo;
import com.sellerbuyer.dto.OrderDTO;
import com.sellerbuyer.exception.SellException;
import com.sellerbuyer.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @program: sell
 * @description: 卖家端商品
 * @author: JunOba
 * @create: 2018-12-13 08:53
 */
@Controller
@RequestMapping("/seller/product")
public class SellerProductController {

    @Autowired
    private ProductService productService;

    /**
    * @Description: 卖家端商品列表
    * @param
    * @return:
    * @Author: JunOba
    * @Date: 2018/12/13
    */
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "10") Integer size,
                             Map<String, Object > map) {
        PageRequest request = new PageRequest(page - 1, size);
        Page<ProductInfo> productInfoPage = productService.findAll(request);
        map.put("productInfoPage", productInfoPage);
        map.put("currentPage", page);
        map.put("size", size);
        return new ModelAndView("product/list", map);
    }

    /**
    * @Description: 商品上架
    * @param
    * @return:
    * @Author: JunOba
    * @Date: 2018/12/13
    */
    @GetMapping("/on_sale")
    public ModelAndView onSale(@RequestParam("productId") String productId,
                               Map<String, Object> map) {
        try {
            productService.onSale(productId);
        } catch (SellException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/product/list");
            return new ModelAndView("common/error", map);
        }
        map.put("url", "/sell/seller/product/list");
        return new ModelAndView("common/success", map);
    }

    /**
    * @Description: 商品下架
    * @param
    * @return:
    * @Author: JunOba
    * @Date: 2018/12/13
    */
    @GetMapping("/off_sale")
    public ModelAndView offSale(@RequestParam("productId") String productId,
                               Map<String, Object> map) {
        try {
            productService.offSale(productId);
        } catch (SellException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/product/list");
            return new ModelAndView("common/error", map);
        }
        map.put("url", "/sell/seller/product/list");
        return new ModelAndView("common/success", map);
    }
}
