package com.example.demo.lambda;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by chenhe on 2018/3/29.
 */
public class FilterTest {
    List<Person> list = new ArrayList<>(1000);

    @Before
    public void before(){
        for (int i=1;i<= 1000;i++){
            Person person = new Person(i%10, ""+i);
            list.add(person);
        }
    }

    @Test
    public void test(){
        Map<Integer,List<Person>> result = list.stream().collect(Collectors.groupingBy(Person::getCityNo));

    }



}
