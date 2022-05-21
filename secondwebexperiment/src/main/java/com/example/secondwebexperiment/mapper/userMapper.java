package com.example.secondwebexperiment.mapper;

import com.example.secondwebexperiment.basic.BasicMapper;
import com.example.secondwebexperiment.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Mapper
public interface userMapper extends BasicMapper {
    @Override
    @Insert("insert into tb_users(user_id,user_name,user_age) values(#{id},#{name},#{age})")
    void insertUser(int id,String name,int age);

    @Override
    @Select("select user_age from tb_users where user_id = #{id}")
    Integer getAgeById(int id);

    @Override
    @Select("select user_id id,user_name name,user_age age from tb_users where user_age = #{age}")
    List<User> getUsersByAge(int age);

    @Override
    @Select("select user_id id,user_name name,user_age age from tb_users where user_age = (select user_age from tb_users where user_id = #{id})")
    List<User> getUserByAgeById(int id);
}
