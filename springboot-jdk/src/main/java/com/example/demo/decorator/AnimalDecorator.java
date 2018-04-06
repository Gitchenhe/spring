package com.example.demo.decorator;

/**
 * Created by chenhe on 2018/3/5.
 */
public abstract class AnimalDecorator implements Animal{
    private Animal animal;

    public AnimalDecorator(Animal animal){
        this.animal = animal;
    }

    public void work(){
        animal.work();
    }
}
