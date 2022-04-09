package com.hello.design.pattern.proxy.jdk.impl;

import com.helloworld.entities.User;
import com.hello.design.pattern.proxy.jdk.UserService;

public class UserServiceImpl implements UserService {

    @Override
    public User getUser() {
        return new User("张三", 18);
    }

}
