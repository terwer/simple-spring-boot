package com.terwergreen.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: terwer
 * @date: 2022/1/5 23:44
 * @description: TestController
 */
@RestController
public class TestController {

    @RequestMapping("/")
    public String home(){
        return "<h1>Hi,this is a simple spring boot application</h1>";
    }

    @RequestMapping("/test")
    public String test(){
        return "hello";
    }
}
