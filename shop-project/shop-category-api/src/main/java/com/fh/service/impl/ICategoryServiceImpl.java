package com.fh.service.impl;

import com.fh.bean.ShopTypeBean;
import com.fh.dao.ICategoryDao;
import com.fh.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ICategoryServiceImpl implements ICategoryService {


    @Autowired
    private ICategoryDao iCategoryDao;

    @Override
    public List<Map<String, Object>> queryCategoryList() {
        List<ShopTypeBean> shopTypeBeanList = iCategoryDao.queryCategoryList();
        return getShopTypeList(0,shopTypeBeanList);
    }

    private List<Map<String, Object>> getShopTypeList(Integer pid, List<ShopTypeBean> shopTypeBeanList) {
        List<Map<String,Object>> list = new ArrayList<>();
        shopTypeBeanList.forEach(shopTypeBean -> {
            Map<String,Object> map = null;
            if (pid.equals(shopTypeBean.getPid())){
                map = new HashMap<>();
                map.put("id",shopTypeBean.getTypeId());
                map.put("name",shopTypeBean.getTypeName());
                map.put("pid",shopTypeBean.getPid());
                map.put("children",getShopTypeList(shopTypeBean.getTypeId(),shopTypeBeanList));
            }
            if (map != null){
                list.add(map);
            }
        });
        return list;
    }
}
