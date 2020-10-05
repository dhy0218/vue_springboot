package com.example.demo.Controller;

import com.example.demo.Service.ServiceImpl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class DeleteController {
    @Autowired
    UserService userService;
    @CrossOrigin
    @GetMapping("/api/deleteById")
    @ResponseBody
    public String deleteById(@RequestParam(value="id")int id)
    {
        System.out.println(id);
        userService.deleteById(id);
        return "success";
    }
}
