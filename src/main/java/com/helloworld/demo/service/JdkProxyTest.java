package com.helloworld.demo.service;

import com.helloworld.demo.entities.User;
import com.helloworld.demo.service.impl.UserServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxyTest implements InvocationHandler {

    Object target;
    public Object bind(Object target){
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy before ... ");
        Object invoke = method.invoke(target, args);
        System.out.println("proxy invoke ...");
        System.out.println("proxy after ... ");
        return invoke;
    }

    public static void main(String[] args) {
        JdkProxyTest jdkProxyTest = new JdkProxyTest();
        UserService bind = (UserService) jdkProxyTest.bind(new UserServiceImpl());
        User user = bind.getUser();
        System.out.println(user.toString());
    }

}
