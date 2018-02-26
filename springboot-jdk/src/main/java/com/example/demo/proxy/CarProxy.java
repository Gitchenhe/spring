package com.example.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * Created by chenhe on 2018/2/26.
 */
public class CarProxy implements InvocationHandler {
    Object object;
    public Object bind(Object object){
        this.object = object;
        return Proxy.newProxyInstance(object.getClass().getClassLoader(),object.getClass().getInterfaces(),this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("调用前,入参:"+ Arrays.asList(args));

        long startTime = System.currentTimeMillis();
        Object result = method.invoke(object,args);

        System.out.println("调用后,出参:"+ result+",耗时:"+(System.currentTimeMillis()-startTime)+"ms");
        return result;
    }
}
