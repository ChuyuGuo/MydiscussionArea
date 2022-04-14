package com.mycode.SpringBootdemo.dao;/*
    @author 🐟🐟🐟
    @create 2022--04--08--10:40
*/

import org.springframework.stereotype.Repository;

@Repository("alphaMybatis") //别名 默认是类名首字母小写
public class AlphaDaoMybatisImpl implements AlphaDao {
    @Override
    public String select() {
        return "Mybatis";
    }
}
