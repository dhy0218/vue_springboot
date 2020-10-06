package com.example.demo.Controller;

import com.example.demo.Service.ServiceImpl.UserService;
import com.example.demo.domain.Result;
import com.example.demo.domain.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import java.util.Objects;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/test")
    @ResponseBody
    public String test()
    {
        return "success";
    }

    @CrossOrigin
    @PostMapping(value = "api/login")
    @ResponseBody
    public Result login(@RequestBody User requestUser)
    {
        //对html标签进行转义防止xss攻击
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);
        User user = userService.finduserbyname(username);
        System.out.println(user);
        if (user == null ||!Objects.equals(user.getUsername(), username) || !Objects.equals(user.getPassword(), requestUser.getPassword())) {
            String message = "账号密码错误";
            System.out.println("test");
            return new Result(400);
        } else {
            //System.out.println("dd");
            return new Result(200);
        }
    }

    @PostMapping(value = "/api/shirologin")
    @CrossOrigin
    @ResponseBody
    public Result shirologin(@RequestBody User requestUser) {
        String username = requestUser.getUsername();
        Subject subject = SecurityUtils.getSubject();
//        subject.getSession().setTimeout(10000);
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, requestUser.getPassword());
        try {
            subject.login(usernamePasswordToken);
            return new Result(200);
        } catch (AuthenticationException e) {
            String message = "账号密码错误";
            return new Result(400);
        }
    }
}
