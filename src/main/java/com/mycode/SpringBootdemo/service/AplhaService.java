package com.mycode.SpringBootdemo.service;/*
    @author 🐟🐟🐟
    @create 2022--04--08--10:57
*/

import com.mycode.SpringBootdemo.dao.AlphaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class AplhaService {

    @Autowired
    private AlphaDao alphaDao;

    public AplhaService() {
        System.out.println("实例化AlphaService");
    }

    @PreDestroy //销毁之前调用
    public void destroy(){
        System.out.println("销毁AlphaService");
    }

    @PostConstruct  //表示在构造器之后调用
    public void init(){
        System.out.println("初始化AlphaService");
    }

    public String find(){
        return alphaDao.select();
    }
}
