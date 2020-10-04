package com.example.demo.Controller;

import com.example.demo.Service.ServiceImpl.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageHelperController {

    @Autowired
    UserService userService;
    @GetMapping("/api/testPageInfo")
    @ResponseBody
    @CrossOrigin
    public PageInfo findByPageInfo(@RequestParam(value="page") int page, @RequestParam(value = "size") int size)
    {
        return userService.findByPageHelper(page,size);
    }

}
