package com.fh.dao;

import com.fh.bean.ProductParamter;
import com.fh.vo.ShopProductVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import utils.PageBean;
import utils.ResponseServer;

import java.util.List;

@Repository
@Mapper
public interface IProductDao {
    
    Long findCount(@Param("parameter") ProductParamter parameter);

    List<ShopProductVo> queryProductList(@Param("page")PageBean<ShopProductVo> page, @Param("parameter")ProductParamter parameter);

    ShopProductVo getProductById(Integer productId);
}
