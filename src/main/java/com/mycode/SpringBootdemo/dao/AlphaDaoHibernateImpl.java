package com.mycode.SpringBootdemo.dao;/*
    @author πππ
    @create 2022--04--08--10:40
*/

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary    //ζι«δΌεηΊ§
public class AlphaDaoHibernateImpl implements AlphaDao {
    @Override
    public String select() {
        return "Hibernate";
    }
}
