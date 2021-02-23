package com.cirnoq.mapper;

import com.cirnoq.pojo.User;


public interface UserMapper {
    int deleteByPrimaryKey(String id);

    int insert(User record);

    //根据用户名查找指定用户对象
    User queryUserNameIsExist(String username);

    int insertSelective(User record);

    User selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}