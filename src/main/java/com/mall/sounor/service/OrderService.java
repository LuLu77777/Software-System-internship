package com.mall.sounor.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mall.sounor.entity.Order;

public interface OrderService {
    void insertOrder(Order order);
    Page<Order> selectOrderPagesById(Integer pageNum, Integer pageSize, String search);
    void updateOrder(Order order);
    void deleteOrder(Integer orderId);
    Order selectOrder(Integer orderId);
}
