package com.cirnoq.services.impl;

import com.cirnoq.mapper.UserMapper;
import com.cirnoq.pojo.User;
import com.cirnoq.services.UserServices;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServicesimpl implements UserServices {

    //注入mapper
    @Autowired
    UserMapper userMapper;
    @Autowired
    Sid sid;
    @Override
    public User getUserById(String id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public User queryUserNameIsExist(String username) {
        User user=userMapper.queryUserNameIsExist(username);
        return user;
    }

    @Override
    public User insert(User user) {
        user.setId(sid.nextShort());
        userMapper.insert(user);
        return user;
    }
}
