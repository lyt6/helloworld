package com.helloworld.demo.service.impl;

import com.helloworld.demo.entities.User;
import com.helloworld.demo.service.UserService;

public class UserServiceImpl implements UserService {

    @Override
    public User getUser() {
        return new User("张三", 18);
    }

}
