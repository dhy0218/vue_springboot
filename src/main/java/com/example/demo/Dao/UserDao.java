package com.example.demo.Dao;

import com.example.demo.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserDao {

    @Select("Select * from user where username = #{username}")
    public User finduserbyname(@Param("username") String username);

    //查询所有用户
    @Select("select * from user")
    List<User> getAllUser();
}
