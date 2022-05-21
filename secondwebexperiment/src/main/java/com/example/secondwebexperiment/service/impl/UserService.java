package com.example.secondwebexperiment.service.impl;

import com.example.secondwebexperiment.mapper.userMapper;
import com.example.secondwebexperiment.pojo.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("UserService")
public class UserService implements com.example.secondwebexperiment.service.UserService {
    @Resource
    private userMapper userMapper;
    @Override
    @Transactional
    public void insertUser(int id,String name,int age){
        userMapper.insertUser(id,name,age);
    }
    @Override
    @Transactional
    public Integer getAgeById(int id){
        Integer num = userMapper.getAgeById(id);
        return num;
    }
    @Override
    @Transactional
    public List<User> getUsersByAge(int age){
        List<User> list = userMapper.getUsersByAge(age);
        return list;
    }
    @Override
    @Transactional
    public  List<User> getUserByAgeById(int id){
        List<User> list = userMapper.getUserByAgeById(id);
        return list;
    }
}
