package com.example.demo.decorator;

/**
 * Created by chenhe on 2018/3/5.
 */
public class Test {

    @org.junit.Test
    public void test(){
        Animal animal = new Cat();
        AnimalDecorator animalDecorator = new CatDecorator(animal);
        animalDecorator.work();
    }
}
