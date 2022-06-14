package com.mall.sounor.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mall.sounor.common.Result;
import com.mall.sounor.entity.Order;
import com.mall.sounor.mapper.OrderMapper;
import com.mall.sounor.service.OrderService;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Resource
    OrderService orderService;

    //    添加订单的
    @PostMapping
    public Result<?> save(@RequestBody Order order){
        orderService.insertOrder(order);
        return Result.success();
    }

    //    更新
    @PutMapping
    public Result<?> update(@RequestBody Order order){
        orderService.updateOrder(order);
        return Result.success();
    }

    //    删除
    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Integer orderId){
        orderService.deleteOrder(orderId);
        return Result.success();
    }

//        根据id查询
    @GetMapping ("/{id}")
    public Result<?> getById(@PathVariable Integer id){
        Order order = orderService.selectOrder(id);
        return Result.success(order);
    }

    //    查询
    @GetMapping("/selectbyorderid")
    public Result<?> findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                              @RequestParam(defaultValue = "10") Integer pageSize,
                              @RequestParam(defaultValue = "") String search){
        Page<Order> orderPage = orderService.selectOrderPagesById(pageNum,pageSize,search);
        return Result.success(orderPage);
    }
}
