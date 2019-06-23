package com.synuwxy.demo.eventbus.web.controller;

import com.synuwxy.demo.eventbus.common.ResultObject;
import com.synuwxy.demo.eventbus.common.observer.ThreadObserver;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/obs")
public class ObserverTestController {

    @GetMapping("/hello")
    public Map hello() {
        return ResultObject.newInstance("0","hello");
    }

    @GetMapping("/world")
    public Map world() {
        return ResultObject.newInstance("0","world");
    }

    @GetMapping("/say")
    public Map say() {
        ThreadObserver.newInstance().tnotify("userID");
        return ResultObject.newInstance("0","say");
    }
}
