package com.yevhenii.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class SimpleRESTController {

    private static final String template = "Hello, %s!";

    @RequestMapping(method = RequestMethod.GET)
    public String get(){
        return "Hello, world!";
    }

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public String post(@RequestParam(value = "name") String name){
        return String.format(template, name);
    }
}
