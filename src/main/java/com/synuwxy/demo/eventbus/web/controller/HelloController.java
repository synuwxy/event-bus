package com.synuwxy.demo.eventbus.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/say")
    public Map sayHello(String name) {
        Map<String,String> map = new HashMap<>();
        map.put("msg","hello " + name);
        return map;
    }

    @PostMapping("/say")
    public Map sayHelloPost(String name) {
        Map<String,String> map = new HashMap<>();
        map.put("msg","hello " + name);
        return map;
    }
}
