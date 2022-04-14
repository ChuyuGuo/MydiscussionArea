package com.mycode.SpringBootdemo.config;/*
    @author 🐟🐟🐟
    @create 2022--04--08--11:08
*/

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

//加载第三方的配置类
@Configuration
public class AlphaConfig {
    @Bean
    public SimpleDateFormat simpleDateFormat(){
        return new SimpleDateFormat("YYYY-HH-DD hh:mm:ss");
    }
}
