package com.mall.sounor.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@TableName("order")
@Data
public class Order {
     @TableId(type = IdType.AUTO)
     private Integer orderId;
     private Integer userId;
     private String userName;
     private Integer goodsId;
     //商品名
     private String name;
     private Integer totalPrice;
     private Integer payStatus;
     @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
     private Date payTime;
}
