package com.example.demo.Service.ServiceImpl;

import com.example.demo.Dao.UserDao;
import com.example.demo.domain.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
     @Autowired(required = false)
     private UserDao userDao;

     public User finduserbyname(String username)
     {
         return userDao.finduserbyname(username);
     }

     public PageInfo findByPageHelper(int page,int size)
     {
          PageHelper.startPage(page,size);
          List<User> list = userDao.getAllUser();
          return new PageInfo(list);
     }
}
