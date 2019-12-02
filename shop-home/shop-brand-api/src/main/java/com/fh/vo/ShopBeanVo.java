package com.fh.vo;


import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class ShopBeanVo {

    private Integer id;

    private String  name;

    private String telPhone;

    private String  webSite;

    private Integer typeId;

    private String  imgUrl;

    private Integer status;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updateTime;

}
