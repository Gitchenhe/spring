package com.example.demo.integer;

import org.junit.Test;

/**
 * Created by chenhe on 2018/3/3.
 */
public class TestInteger {


    @Test
    public void testIntegerToString(){
        System.out.println("进制转换");
        String val = Integer.toString(10,2);
        System.out.println(val);
    }

    @Test
    public void testIntegerCache(){
        Integer integer = 10;
        Integer integer2 = 30;
        Integer integer1 = 10;
        Integer integer3 = 128;
        Integer integer4 = 128;

        System.out.println(integer == integer1);

        System.out.println(integer3 == integer4);

    }
}
