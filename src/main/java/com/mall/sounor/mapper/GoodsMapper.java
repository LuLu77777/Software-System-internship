package com.mall.sounor.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mall.sounor.entity.Goods;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface GoodsMapper extends BaseMapper<Goods> {
    @Select("select * from goods where id = #{id}")
    Goods selectGoods(@Param("id") Integer id);
}
