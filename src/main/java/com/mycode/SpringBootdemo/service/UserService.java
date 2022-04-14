package com.mycode.SpringBootdemo.service;/*
    @author 🐟🐟🐟
    @create 2022--04--12--16:34
*/

import com.mycode.SpringBootdemo.dao.UserMapper;
import com.mycode.SpringBootdemo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User findUserById(int id){
        return userMapper.selectById(id);
    }
}
