package com.mall.sounor.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mall.sounor.common.Result;
import com.mall.sounor.entity.Goods;
import com.mall.sounor.entity.User;
import com.mall.sounor.mapper.UserMapper;
import com.mall.sounor.service.UserService;
import netscape.javascript.JSObject;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("/login")
    public Result<?> login(@RequestBody User user){
        User res = userService.selectUser(user);
        if(res == null){
            return Result.error("-1","用户名或密码错误");
        }
        //生成token
//        String token = TokenUtils.
        return Result.success(res);
    }

    @PostMapping("/register")
    public Result<?> register(@RequestBody User user){
        User res = userService.selectUser(user);
        if(res != null){
            return Result.error("-1","用户名重复");
        }
        if(user.getPassword() == null){
            user.setPassword("123456");
        }
        userService.insertUser(user);
        return Result.success();
    }

    @PostMapping
    public Result<?> save(@RequestBody User user){
        if(user.getPassword() == null){
            user.setPassword("123456");  //设置默认密码
        }
        userService.insertUser(user);
        return Result.success();
    }

    /**
     *
     * @param pageNum 分页分多少页
     * @param pageSize 每页多少条
     * @param search 怎么根据id查
     * @return
     */
    @GetMapping("/selectbyid")
    public Result<?> findPageById(@RequestParam(defaultValue = "1") Integer pageNum,
                              @RequestParam(defaultValue = "10") Integer pageSize,
                              @RequestParam(defaultValue = "") String search){
        Page<User> userPage = userService.selectUserPagesById(pageNum, pageSize, search);
        return Result.success(userPage);
    }

    /**
     *
     * @param pageNum 分页分多少页
     * @param pageSize 每页多少条
     * @param find 怎么根据username查
     * @return
     */
    @GetMapping("/selectbyusername")
    public Result<?> findPageByUsername(@RequestParam(defaultValue = "1") Integer pageNum,
                              @RequestParam(defaultValue = "10") Integer pageSize,
                              @RequestParam(defaultValue = "") String find){
        Page<User> userPage = userService.selectUserPagesByUsername(pageNum, pageSize, find);
        return Result.success(userPage);
    }

    @PutMapping
    public Result<?> updateUser(@RequestBody User user){
        userService.updateUser(user);
        return  Result.success();
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Long id){
        userService.deleteUser(id);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<?> getById(@PathVariable Long id){
        return Result.success(userService.selectUserById(id));
    }

    @GetMapping("/id")
    public Result<?> selectUserById(@RequestParam(defaultValue = "4") Long idd){
        User user = userService.selectUserById(idd);
        return Result.success(user);
    }
}
