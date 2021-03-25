package com.helloworld.demo.javase.jvm;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 使用Java -XX:+PrintFlagsInitial命令查看本机的初始化参数，-XX:MetaspaceSize为21810376B(约20M)
 */
public class MetaSpaceError {
    static class OOMTest {
    }

    public static void main(String[] args) {
        int i = 0;
        try {
            while (true) {
                Enhancer enhancer = new Enhancer();
                enhancer.setSuperclass(OOMTest.class);
                enhancer.setUseCache(false);
                enhancer.setCallback(new MethodInterceptor() {
                    @Override
                    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                        return methodProxy.invoke(o, args);
                    }
                });
                enhancer.create();
            }
        } catch (Throwable throwable) {
            System.out.println("--- metaspace OOM i = " + i);
            throwable.printStackTrace();
        }
    }
}
