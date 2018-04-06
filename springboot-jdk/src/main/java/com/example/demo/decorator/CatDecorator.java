package com.example.demo.decorator;

/**
 * Created by chenhe on 2018/3/5.
 */
public class CatDecorator extends AnimalDecorator{
    public CatDecorator(Animal animal) {
        super(animal);
    }

    public void work() {
        super.work();
        System.out.println("猫悠闲的行走");
    }
}
