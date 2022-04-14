package com.mycode.SpringBootdemo.dao;/*
    @author 🐟🐟🐟
    @create 2022--04--08--10:40
*/

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary    //提高优先级
public class AlphaDaoHibernateImpl implements AlphaDao {
    @Override
    public String select() {
        return "Hibernate";
    }
}
