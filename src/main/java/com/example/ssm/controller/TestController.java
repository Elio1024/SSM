package com.example.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes({"name", "age"})
public class TestController {

    @RequestMapping("session")
    public String session(Model model){
        model.addAttribute("name", "elio");
        model.addAttribute("age", "10");
        return "redirect:newSession1";
    }
    @RequestMapping("newSession")
    public String newSession(HttpSession session){
        System.out.println(session.getAttribute("name") + "  " + session.getAttribute("age"));
        return "/";
    }
    @RequestMapping("newSession1")
    public String newSession1(@SessionAttribute("name") String name, @SessionAttribute("age") Integer age){
        System.out.println(name + " " + age);
        return "/";
    }

    @RequestMapping("/abc")
    public String abc(RedirectAttributes redirectAttributes){
        redirectAttributes.addAttribute("name", "elio");
        return "redirect:/def";
    }
    @RequestMapping("/def")
    public String def(String name){
        System.out.println("======================" + name + "======================");
        return "";
    }
    @RequestMapping("/path/{name}/{id}")
    public String path(@PathVariable("id") Integer id, @PathVariable("name") String name){
        System.out.println(name + "" + id);
        return "";
    }
}
