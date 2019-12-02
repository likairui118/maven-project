package com.fh.service.impl;

import com.fh.bean.ProductParamter;
import com.fh.dao.IProductDao;
import com.fh.service.IProductService;
import com.fh.vo.ShopProductVo;
import com.sun.xml.internal.ws.developer.Serialization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utils.PageBean;
import utils.ResponseServer;

import javax.validation.constraints.Max;
import java.util.List;

@Service
public class IProductServiceImpl implements IProductService {


    @Autowired
    private IProductDao productDao;

    @Override
    public PageBean<ShopProductVo> queryProductList(PageBean<ShopProductVo> page, ProductParamter parameter) {
        Long count = productDao.findCount(parameter);
        page.setRecordsFiltered(count);
        page.setRecordsTotal(count);
        List<ShopProductVo> list = productDao.queryProductList(page,parameter);
        page.setData(list);
        return page;
    }

    @Override
    public ResponseServer getProductById(Integer productId) {
        ShopProductVo shopProductVo = productDao.getProductById(productId);
        return ResponseServer.success(shopProductVo);
    }
}
