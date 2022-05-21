package com.example.secondwebexperiment.web;

import com.example.secondwebexperiment.pojo.User;
import com.example.secondwebexperiment.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserController {
    @Resource
    private UserService userService;
    Integer getage = 0;
    @GetMapping("/user/insertuser")
    public String insert(int id,String name,int age){
        userService.insertUser(id,name,age);
        System.out.println(id+"      "+name+"      "+age);
        return id+"      "+name+"      "+age;
    }
    @GetMapping("/user/getagebyid")
    public Integer queryId(int id){
        getage = userService.getAgeById(id);
        return userService.getAgeById(id);
    }
    @GetMapping("/user/getuserbyage")
    public String queryUser(int age){
        String ans = "";
        List<User> list=userService.getUsersByAge(age);
        for (User u:list) {
            System.out.println(u);
            ans+=(u.getId()+"      "+u.getName()+"      "+u.getAge()+"           ");
        }
        return ans;
    }
    @GetMapping("/user/getuserbyagebyid")
    public String getUser(int id){
        String ans = "";
        List<User> list=userService.getUserByAgeById(id);
        for (User u:list) {
            System.out.println(u);
            ans+=(u.getId()+"      "+u.getName()+"      "+u.getAge()+"           ");
        }
        return ans;
    }
}