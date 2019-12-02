package com.fh.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@TableName("t_shop")
@Data
public class ShopBean {

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    @TableField("name")
    private String  name;

    @TableField("telPhone")
    private String telPhone;

    @TableField("webSite")
    private String  webSite;

    @TableField("typeId")
    private Integer typeId;

    @TableField("imgUrl")
    private String  imgUrl;

    @TableField("status")
    private Integer status;

    @TableField("updateTime")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updateTime;


}
