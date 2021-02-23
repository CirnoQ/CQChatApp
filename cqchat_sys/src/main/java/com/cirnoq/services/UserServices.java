package com.cirnoq.services;


import com.cirnoq.pojo.User;

public interface UserServices {
    User getUserById(String id);
    //根据用户名查找指定用户对象
    User queryUserNameIsExist(String username);
    //保存
    User insert(User user);

}
