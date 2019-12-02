package com.fh.dao;

import com.fh.bean.ShopBean;
import com.fh.vo.ShopBeanVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface IBrandDao {

    List<ShopBeanVo> queryBrandList();
}
