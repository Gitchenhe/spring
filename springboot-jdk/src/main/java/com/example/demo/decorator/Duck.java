package com.example.demo.decorator;

/**
 * Created by chenhe on 2018/3/5.
 */
public class Duck implements Animal {
    @Override
    public void work() {
        System.out.println("鸭子行走");
    }
}
