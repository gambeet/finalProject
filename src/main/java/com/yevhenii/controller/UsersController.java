package com.yevhenii.controller;

import com.yevhenii.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UsersService usersService;

    @RequestMapping
    public String list(Model model){
        model.addAttribute("users", usersService.getAll());
        return "users";
    }
}
