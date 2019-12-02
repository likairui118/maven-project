package com.fh.service;

import com.fh.bean.ProductParamter;
import com.fh.vo.ShopProductVo;
import utils.PageBean;
import utils.ResponseServer;

public interface IProductService {

    PageBean<ShopProductVo> queryProductList(PageBean<ShopProductVo> page, ProductParamter parameter);

    ResponseServer getProductById(Integer productId);
}
