package com.mycode.SpringBootdemo.dao;/*
    @author 🐟🐟🐟
    @create 2022--04--11--20:35
*/

import com.mycode.SpringBootdemo.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User selectById(int id);

    User selectByName(String name);

    User selectByEmail(String email);

    int insertUser(User user);

    int updateStatus(int id,int status);

    int updateHeader(int id,String headerUrl);

    int updatePassword(int id,String password);
}
