package com.mall.sounor.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mall.sounor.entity.User;

import java.sql.Wrapper;

public interface UserService {
    void insertUser(User user);
    Page<User> selectUserPagesById(Integer pageNum, Integer pageSize, String search);
    Page<User> selectUserPagesByUsername(Integer pageNum, Integer pageSize, String find);
    void updateUser(User user);
    void deleteUser(Long id);
    User selectUser(User user);
    User selectUserById(Long id);
}
