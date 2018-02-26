package com.example.demo.proxy;

/**
 * Created by chenhe on 2018/2/26.
 */
public class CarInterImpl implements CarInter {
    @Override
    public String run(String name) {
        System.out.println("car " +name+ " running");
        return "car running";
    }
}
