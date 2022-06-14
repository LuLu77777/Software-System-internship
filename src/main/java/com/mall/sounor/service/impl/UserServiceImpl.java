package com.mall.sounor.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mall.sounor.entity.User;
import com.mall.sounor.mapper.UserMapper;
import com.mall.sounor.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public void insertUser(User user){
        userMapper.insert(user);
    }

    @Override
    public Page<User> selectUserPagesById(Integer pageNum, Integer pageSize, String search){
        LambdaQueryWrapper<User> wrapper = Wrappers.<User>lambdaQuery();
        if(StrUtil.isNotBlank(search)){
            wrapper.like(User::getId,search);
        }
        return userMapper.selectPage(new Page<>(pageNum,pageSize),wrapper);
    }

    @Override
    public Page<User> selectUserPagesByUsername(Integer pageNum, Integer pageSize, String find){
        LambdaQueryWrapper<User> wrapper = Wrappers.<User>lambdaQuery();
        if(StrUtil.isNotBlank(find)){
            wrapper.like(User::getUsername,find);
        }
        return userMapper.selectPage(new Page<>(pageNum,pageSize),wrapper);
    }

    @Override
    public void updateUser(User user){
        userMapper.updateById(user);
    }

    @Override
    public void deleteUser(Long id){
        userMapper.deleteById(id);
    }

    @Override
    public User selectUser(User user){
        //        User needUser = userMapper.selectOne(Wrappers.lambdaQuery().eq(User::getUsername,user.getUsername()).eq(User::getPassword,user.getPassword()));
        User needUser = userMapper.selectUser(user);
        return needUser;
    }

    @Override
    public User selectUserById(Long id){
//        User needUser = userMapper.selectOne(Wrappers.lambdaQuery().eq(User::getUsername,user.getUsername()).eq(User::getPassword,user.getPassword()));
        User needUser = userMapper.selectById(id);
        return needUser;
    }
}
