package com.mall.sounor.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mall.sounor.common.Result;
import com.mall.sounor.entity.Goods;
import com.mall.sounor.service.GoodsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Resource
    private GoodsService goodsService;

    @PostMapping
    public Result<?> save(@RequestBody Goods goods){
        goodsService.insertGoods(goods);
        return Result.success();
    }

    /**
     *
     * @param pageNum 分页分多少页
     * @param pageSize 每页多少条
     * @param search 怎么查
     * @return
     */
    @GetMapping("/selectbyid")
    public Result<?> findPageById(@RequestParam(defaultValue = "1") Integer pageNum,
                              @RequestParam(defaultValue = "10") Integer pageSize,
                              @RequestParam(defaultValue = "") String search){
        Page<Goods> goodsPage = goodsService.selectGoodsPagesById(pageNum,pageSize,search);
        return Result.success(goodsPage);
    }

    @GetMapping("/selectbyname")
    public Result<?> findPageByName(@RequestParam(defaultValue = "1") Integer pageNum,
                              @RequestParam(defaultValue = "10") Integer pageSize,
                              @RequestParam(defaultValue = "") String find){
        Page<Goods> goodsPage = goodsService.selectGoodsPagesByName(pageNum,pageSize,find);
        return Result.success(goodsPage);
    }

    @PutMapping
    public Result<?> updateGoods(@RequestBody Goods goods){
        goodsService.updateGoods(goods);
        return  Result.success();
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Integer id){
        goodsService.deleteGoods(id);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<?> getById(@PathVariable Integer id){
        Goods needGoods = goodsService.selectGoods(id);
        return Result.success(needGoods);
    }
}
