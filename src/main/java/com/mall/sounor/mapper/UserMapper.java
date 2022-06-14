package com.mall.sounor.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mall.sounor.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper extends BaseMapper<User> {
    @Select("select * from user where username = #{user.username} and password = #{user.password}")
    User selectUser(@Param("user") User user);
    //一对多查询
//    Page<User> findPage(Page<User> page);
}
