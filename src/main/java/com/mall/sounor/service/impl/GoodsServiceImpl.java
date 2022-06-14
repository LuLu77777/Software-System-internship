package com.mall.sounor.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mall.sounor.entity.Goods;
import com.mall.sounor.mapper.GoodsMapper;
import com.mall.sounor.service.GoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Resource
    private GoodsMapper goodsMapper;

    @Override
    public void insertGoods(Goods goods){
        goodsMapper.insert(goods);
    }

    @Override
    public Page<Goods> selectGoodsPagesById(Integer pageNum, Integer pageSize, String search){
        LambdaQueryWrapper<Goods> wrapper = Wrappers.<Goods>lambdaQuery();
        if(StrUtil.isNotBlank(search)){
            wrapper.like(Goods::getId,search);
        }
        return goodsMapper.selectPage(new Page<>(pageNum,pageSize),wrapper);
    }

    @Override
    public Page<Goods> selectGoodsPagesByName(Integer pageNum, Integer pageSize, String search){
        LambdaQueryWrapper<Goods> wrapper = Wrappers.<Goods>lambdaQuery();
        if(StrUtil.isNotBlank(search)){
            wrapper.like(Goods::getName,search);
        }
        return goodsMapper.selectPage(new Page<>(pageNum,pageSize),wrapper);
    }

    @Override
    public void updateGoods(Goods goods){
        goodsMapper.updateById(goods);
    }

    @Override
    public void deleteGoods(Integer id){
        goodsMapper.deleteById(id);
    }

    @Override
    public Goods selectGoods(Integer id){
//        User needUser = userMapper.selectOne(Wrappers.lambdaQuery().eq(User::getUsername,user.getUsername()).eq(User::getPassword,user.getPassword()));
        Goods needGoods = goodsMapper.selectGoods(id);
        return needGoods;
    }
}
