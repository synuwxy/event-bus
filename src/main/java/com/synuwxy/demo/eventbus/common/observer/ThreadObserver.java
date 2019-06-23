package com.synuwxy.demo.eventbus.common.observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ThreadObserver {

    private static Map<String, ArrayList<Object>> map = new HashMap<>();

    private static ThreadObserver threadObserver;

    private ThreadObserver() {}

    public static ThreadObserver newInstance() {
        if (threadObserver == null) {
            synchronized (ThreadObserver.class) {
                threadObserver = new ThreadObserver();
            }
        }
        return threadObserver;
    }

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
