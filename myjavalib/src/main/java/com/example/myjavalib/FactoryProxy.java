package com.example.myjavalib;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class FactoryProxy implements InvocationHandler {
    Object mObject;

    public FactoryProxy(Object object){
        mObject=object;
    }

    public Object getProInstance(){
      return   Proxy.newProxyInstance(mObject.getClass().getClassLoader(),mObject.getClass().getInterfaces(),this);
    }


    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        System.out.println("do something");
        Object invoke = method.invoke(mObject, objects);
        return invoke;
    }

}
