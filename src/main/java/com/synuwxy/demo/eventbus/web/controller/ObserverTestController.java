package com.synuwxy.demo.eventbus.web.controller;

import com.synuwxy.demo.eventbus.common.ResultObject;
import com.synuwxy.demo.eventbus.common.observer.ThreadObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/obs")
public class ObserverTestController {


    private final ThreadObserver threadObserver;

    @Autowired
    public ObserverTestController(ThreadObserver threadObserver) {
        this.threadObserver = threadObserver;
    }

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
        threadObserver.tnotify("userID");
        return ResultObject.newInstance("0","say");
    }
}
