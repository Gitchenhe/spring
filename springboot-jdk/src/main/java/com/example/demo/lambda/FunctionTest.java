package com.example.demo.lambda;

import org.junit.Test;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Created by chenhe on 2018/3/1.
 */
public class FunctionTest {

    @Test
    public void functionTest() {
        String a = map(10, t -> t + "100");
        System.out.println(a);
    }

    @Test
    public void biFunctionTest(){
        String b = map(10, "实际收到:", (t, x) -> x + t);
        System.out.println(b);
    }

    public String map(Integer val, Function<Integer, String> function) {
        return function.apply(val);
    }

    public String map(Integer val, String val2, BiFunction<Integer, String, String> biFunction) {
        return biFunction.apply(val, val2);
    }
}
