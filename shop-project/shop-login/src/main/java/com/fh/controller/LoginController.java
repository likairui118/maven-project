package com.fh.controller;


import com.fh.bean.CustomerBean;
import com.fh.jwt.JwtUtils;
import com.fh.service.ICustomerService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import utils.ResponseServer;
import utils.ServerEnum;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/logins")
@CrossOrigin(maxAge = 3600, origins = "http://localhost:8080")
public class LoginController {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private ICustomerService customerService;

    @GetMapping("/{phone}")
    public ResponseServer sendCode(@PathVariable String phone) throws IOException {
        //先判断一下
        if (StringUtils.isBlank(phone)) {
            return ResponseServer.error(ServerEnum.PHONE_ISNULL);
        }
        //先发送验证码
        /*JSONObject jsonObject = SendMessage.sendMessage(phone);
        String code = jsonObject.getString("code");
        if (code.equals("200")) {
            String checkCode = jsonObject.getString("obj");
            redisTemplate.opsForValue().set("code_" + phone, checkCode, 300, TimeUnit.SECONDS);
        }*/

        /*JSONObject jsonObject = SendMessage.sendMessage(phone);
        String code = jsonObject.getString("code");
        if (code.equals("200")) {
            String checkCode = jsonObject.getString("obj");
            redisTemplate.opsForValue().set("code_" + phone, checkCode, 300, TimeUnit.SECONDS);
        }*/

        redisTemplate.opsForValue().set("code_" + phone, "111111", 300, TimeUnit.SECONDS);

        //如果没注册先注册
        return ResponseServer.success();
    }

    //用户登录
    @PostMapping
    public ResponseServer login(String phone, String checkCode) {
        //判断手机号码或者验证码不能为空
        if (StringUtils.isBlank(phone) || StringUtils.isBlank(checkCode)) {
            return ResponseServer.error(ServerEnum.LOGIN_PHONEORCODE_ISNULL);
        }
        //验证验证码是否正确
        String code = (String) redisTemplate.opsForValue().get("code_" + phone);
        if (!checkCode.equals(code)) {
            return ResponseServer.error(ServerEnum.LOGIN_CODE_ERROR);
        }
        //输入成功之后删除redis里的验证码
        redisTemplate.delete("code_" + phone);
        //判断手机号是否存在，不存在就注册
        CustomerBean customerBean = customerService.isRegist(phone);
        if(customerBean==null){

        }else{

        }
        redisTemplate.opsForValue().set("user_"+phone,customerBean);
        redisTemplate.opsForValue().set("cartid_"+phone,customerBean.getCartId());
        //生成token
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("phone",customerBean.getPhone());
        String token = JwtUtils.createToken(map);
        System.out.println(token);
        return ResponseServer.success(token);
    }
}
