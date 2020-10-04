package com.example.demo.Controller;

import com.example.demo.Service.ServiceImpl.UserService;
import com.example.demo.domain.Result;
import com.example.demo.domain.User;
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
        if (!Objects.equals(user.getUsername(), username) || !Objects.equals(user.getPassword(), requestUser.getPassword())) {
            String message = "账号密码错误";
            System.out.println("test");
            return new Result(400);
        } else {
            //System.out.println("dd");
            return new Result(200);
        }
    }
}
