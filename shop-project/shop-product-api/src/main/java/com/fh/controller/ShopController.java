package com.fh.controller;


import com.fh.bean.ProductParamter;
import com.fh.bean.ShopProductBean;
import com.fh.service.IProductService;
import com.fh.vo.ShopProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import utils.PageBean;

@RestController
@RequestMapping("/shopProduct")
@CrossOrigin(maxAge = 3600,origins = "http://localhost:8080")
public class ShopController {

    @Autowired
    private IProductService productService;

    @PostMapping
    public PageBean<ShopProductVo> queryProductList(PageBean<ShopProductVo> page, ProductParamter parameter){
        return productService.queryProductList(page,parameter);
    }

}
