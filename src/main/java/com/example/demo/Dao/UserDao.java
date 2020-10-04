package com.example.demo.Dao;

import com.example.demo.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {

    @Select("Select * from user where username = #{username}")
    public User finduserbyname(@Param("username") String username);

}
