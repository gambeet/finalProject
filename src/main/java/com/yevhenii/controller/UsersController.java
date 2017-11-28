package com.yevhenii.controller;

import com.yevhenii.model.User;
import com.yevhenii.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UsersService usersService;

    @RequestMapping
    public String list(Model model){
        List<User> users = usersService.getAll();
        System.out.println(users.get(0).getUserToRolesById().size());
        model.addAttribute("users", users);
        return "users";
    }
}
