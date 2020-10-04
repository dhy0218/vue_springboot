package com.example.demo.Service.ServiceImpl;

import com.example.demo.Dao.UserDao;
import com.example.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
     @Autowired(required = false)
     private UserDao userDao;

     public User finduserbyname(String username)
     {
         return userDao.finduserbyname(username);
     }


}
