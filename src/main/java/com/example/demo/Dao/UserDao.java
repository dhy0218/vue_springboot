package com.example.demo.Dao;

import com.example.demo.domain.User;
import com.example.demo.domain.shiroUser;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDao {

    @Select("Select * from user where username = #{username}")
    public User finduserbyname(@Param("username") String username);

    @Select("Select * from shirouser where username = #{username}")
    public shiroUser findshirouserbyname(@Param("username") String username);

    //查询所有用户
    @Select("select * from user")
    List<User> getAllUser();

    @Delete("delete from user where id = #{id}")
    public void deleteById(@Param("id")int id);

    @Insert("insert into shiroUser(username,password,salt) values (#{username},#{password},#{salt})")
    public void addShiroUser(@Param("username")String username,@Param("password")String password,@Param("salt")String salt);
}
