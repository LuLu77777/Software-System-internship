package com.example.secondwebexperiment.service;

import com.example.secondwebexperiment.pojo.User;

import java.util.List;

public interface UserService {
    void insertUser(int id,String name,int age);
    Integer getAgeById(int id);
    List<User> getUsersByAge(int age);
    List<User> getUserByAgeById(int id);
}
