package com.example.remote;

import org.springframework.beans.factory.FactoryBean;


/**
 * Created by chenhe on 2018/2/23.
 */
public abstract class AbstractRemoteServiceProxyFactoryBean<T> implements FactoryBean<Object> {

    public abstract T getRemoteProxy();

    @Override
    public Object getObject() throws Exception {
        return null;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
