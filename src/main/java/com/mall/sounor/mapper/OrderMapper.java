package com.mall.sounor.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mall.sounor.entity.Order;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface OrderMapper extends BaseMapper<Order> {
    @Select("select order_id from order where order_id = #{order.orderId}")
    Order selectOrder(@Param("order") Integer order);
}
