package com.example.demo;

/**
 * Created by chenhe on 2018/2/24.
 */
public interface inter3 extends inter1,inter2 {
    @Override
    default void func1(){
        System.out.println("in inter3");
    }
}
