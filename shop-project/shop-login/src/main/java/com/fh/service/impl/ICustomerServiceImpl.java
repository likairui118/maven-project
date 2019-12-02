package com.fh.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fh.bean.CustomerBean;
import com.fh.dao.ICustomerDao;
import com.fh.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
public class ICustomerServiceImpl implements ICustomerService {

    @Autowired
    private ICustomerDao customerDao;

    @Override
    @Transactional
    public CustomerBean isRegist(String phone) {
        //判断手机号是否存在
        QueryWrapper queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("phone",phone);
        CustomerBean customerBean = customerDao.selectOne(queryWrapper);
        if (customerBean == null){
            customerBean = new CustomerBean();
            customerBean.setModifiedTime(new Date());
            customerBean.setUserStats(1);
            customerBean.setPhone(phone);
            customerBean.setCartId(UUID.randomUUID().toString());
            customerDao.insert(customerBean);
        }else{
            customerBean.setModifiedTime(new Date());
            customerDao.updateById(customerBean);
        }
        return customerBean;
    }
}
