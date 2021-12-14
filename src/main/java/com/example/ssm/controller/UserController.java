package com.example.ssm.controller;

import com.example.ssm.domain.User;
import com.example.ssm.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/")
    public String findAll(Model model){
        model.addAttribute("users", userMapper.findAll());
        return "users";
    }

    @RequestMapping("add")
    public String add(){
        return "add";
    }

    @RequestMapping("addUser")
    public String addUser(User user){
        userMapper.save(user);
        return "redirect:/";
    }
    @RequestMapping("deleteUser")
    public String deleteUser(Integer id){
        userMapper.deleteUser(id);
        return "redirect:/";
    }
    @RequestMapping("update")
    public String update(Integer id, Model model){
        model.addAttribute("user", userMapper.findOne(id));
        return "updateUser";
    }
    @RequestMapping("updateUser")
    public String updateUser(User user){
        userMapper.updateUser(user);
        return "redirect:/";
    }
}

