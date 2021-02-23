package com.cirnoq.mapper;

import com.cirnoq.pojo.Chatmsg;

public interface ChatmsgMapper {
    int deleteByPrimaryKey(String id);

    int insert(Chatmsg record);

    int insertSelective(Chatmsg record);

    Chatmsg selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Chatmsg record);

    int updateByPrimaryKey(Chatmsg record);
}