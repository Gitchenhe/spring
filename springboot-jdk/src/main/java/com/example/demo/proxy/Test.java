package com.example.demo.proxy;

/**
 * Created by chenhe on 2018/2/26.
 */
public class Test {
    public static void main(String[] args) {
        CarProxy carProxy = new CarProxy();
        CarInter carInter = (CarInter) carProxy.bind(new CarInterImpl());
        carInter.run("奔驰");
    }
}
