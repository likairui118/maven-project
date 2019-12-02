package com.fh.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ShopProductVo {

    private Integer id;

    private Integer brandId;

    private String name;

    private String subtitle;

    private String mainImg;

    //价格类型防止精度不达标
    private BigDecimal price;

    private Integer stock;

    private Integer status;

    private Date createTime;

    private Date updateTime;


    //展示品牌名称使用
    private String brandName;
    //展示商品类型名称
    private String categroyName;
    //获取商品类型ID
    private String categroyIds;
}
