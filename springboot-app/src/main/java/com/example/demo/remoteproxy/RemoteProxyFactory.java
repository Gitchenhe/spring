package com.example.demo.remoteproxy;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by chenhe on 2018/2/26.
 */
@Component
public class RemoteProxyFactory<T> implements FactoryBean{
    private String url;
    private Class<T> serviceInterface;

    @Autowired
    private RestTemplate restTemplate;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Class<T> getServiceInterface() {
        return serviceInterface;
    }

    public void setServiceInterface(Class<T> serviceInterface) {
        this.serviceInterface = serviceInterface;
    }


    @Override
    public Object getObject() throws Exception {
        InnerInvocationHandler handler = new InnerInvocationHandler();
        return Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),new Class[]{serviceInterface},handler);
    }

    @Override
    public Class<?> getObjectType() {
        return serviceInterface;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }


    public Object getProxyObject(){
        return null;
    }
    class InnerInvocationHandler implements InvocationHandler{

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            return method.invoke(getProxyObject(),args);
        }
    }
}
