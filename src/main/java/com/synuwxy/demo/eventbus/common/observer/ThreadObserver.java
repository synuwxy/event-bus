package com.synuwxy.demo.eventbus.common.observer;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Component
public class ThreadObserver {

    private Map<String, ArrayList<Object>> map = new HashMap<>();

    public void add(String name, Object obj) {
        if (map.get(name) == null) {
            ArrayList<Object> arr = new ArrayList<>();
            arr.add(obj);
            map.put(name,arr);
        }
        else {
            map.get(name).add(obj);
        }
    }

    public void tnotify(String name) {
        ArrayList<Object> array = map.get(name);
        if (array == null) {
            return;
        }
        for (Object obj : array) {
            synchronized (obj) {
                obj.notify();
            }
        }
    }
}
