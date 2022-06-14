package com.mall.sounor.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mall.sounor.entity.Goods;

import java.util.List;

public interface GoodsService {
    void insertGoods(Goods goods);
    Page<Goods> selectGoodsPagesById(Integer pageNum, Integer pageSize, String search);
    Page<Goods> selectGoodsPagesByName(Integer pageNum, Integer pageSize, String search);
    void updateGoods(Goods goods);
    void deleteGoods(Integer id);
    Goods selectGoods(Integer id);
}
