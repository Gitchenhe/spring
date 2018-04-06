package com.example.demo.lambda;

/**
 * Created by chenhe on 2018/3/29.
 */
public class Person {
    private final int cityNo;
    private final String name;

    public Person(int cityNo, String name) {
        this.cityNo = cityNo;
        this.name = name;
    }

    public int getCityNo() {
        return cityNo;
    }


    public String getName() {
        return name;
    }
}
