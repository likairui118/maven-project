package com.fh.service.impl;


import com.fh.dao.IBrandDao;
import com.fh.service.IBrandService;
import com.fh.vo.ShopBeanVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utils.ResponseServer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandServiceImpl implements IBrandService {

    @Autowired
    private IBrandDao iBrandDao;



    @Override
    public ResponseServer queryBrandList(Integer pid) {
        List<ShopBeanVo> shopBeanVoList=new ArrayList<>();
        shopBeanVoList=iBrandDao.queryBrandList();
        List<ShopBeanVo> returnList= shopBeanVoList.stream()
                .filter(ShopBeanVo->ShopBeanVo.getTypeId().equals(pid))
                .collect(Collectors.toList());
        return ResponseServer.success(returnList);

        /*Boolean isExistBrand=redisTemplate.hasKey("brands");
        List<ShopBeanVo> shopBeanVoList=new ArrayList<>();
        if(isExistBrand){
            shopBeanVoList= (List<ShopBeanVo>) redisTemplate.opsForValue().get("brands");
        }else{
            shopBeanVoList=iBrandDao.queryBrandList();
            redisTemplate.opsForValue().set("brands",shopBeanVoList);
        }
        List<ShopBeanVo> returnList= shopBeanVoList.stream()
                .filter(ShopBeanVo->ShopBeanVo.getTypeId().equals(pid))
                .collect(Collectors.toList());
        return ResponseServer.success(returnList);*/
    }
}
