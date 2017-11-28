package com.yevhenii.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Yevhenii on 28.11.2017.
 */
@Controller
@RequestMapping("/")
public class MainController {
    @RequestMapping
    public String index(){
        return "index";
    }
}
