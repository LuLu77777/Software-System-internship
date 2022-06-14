package com.mall.sounor.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mall.sounor.entity.Order;
import com.mall.sounor.entity.User;
import com.mall.sounor.mapper.OrderMapper;
import com.mall.sounor.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderMapper orderMapper;

    @Override
    public void insertOrder(Order order) {
        orderMapper.insert(order);
    }

    @Override
    public Page<Order> selectOrderPagesById(Integer pageNum, Integer pageSize, String search) {
        LambdaQueryWrapper<Order> wrapper = Wrappers.<Order>lambdaQuery();
        if(StrUtil.isNotBlank(search)){
            wrapper.eq(Order::getName,search);
        }
        return orderMapper.selectPage(new Page<>(pageNum,pageSize),wrapper);
    }

    @Override
    public void updateOrder(Order order) {
        orderMapper.updateById(order);
    }

    @Override
    public void deleteOrder(Integer orderId) {
        orderMapper.deleteById(orderId);
    }

    @Override
    public Order selectOrder(Integer orderId) {
        Order order= orderMapper.selectOrder(orderId);
        return order;
    }
}
