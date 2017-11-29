package com.yevhenii.controller;

import com.yevhenii.model.User;
import com.yevhenii.service.UsersService;
import com.yevhenii.utils.SortingUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UsersService usersService;

    @RequestMapping()
    public String list(@PathVariable("algorithm") String algorithm, Model model){
        List<User> users = usersService.getAll();
        System.out.println(users.get(0).getUserToRolesById().size());
        model.addAttribute("users", users);
        User[] arr = new User[0];
        arr = users.toArray(arr);
        switch (algorithm) {
            case "bubble":
                SortingUsers.bubbleSort(arr);
                break;
            case "insert":
                SortingUsers.insertSort(arr);
                break;
            default:
                SortingUsers.quickSort(arr);
                break;
        }

        List sortedList = new ArrayList();
        for (User user : arr) {
            sortedList.add(user);
        }
        model.addAttribute("sortedUsers", sortedList);
        return "users";
    }
}
