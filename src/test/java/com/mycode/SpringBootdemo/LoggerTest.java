package com.mycode.SpringBootdemo;/*
    @author 🐟🐟🐟
    @create 2022--04--14--10:19
*/

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = SpringBootdemoApplication.class)
public class LoggerTest {
    //工厂 getLogger(String name) 传入的name就是logger的名字,通常传类名
    private static final Logger logger = LoggerFactory.getLogger(LoggerTest.class);

    @Test
    public void testLogger(){
        System.out.println(logger.getName());

        logger.debug("debug.log");
        logger.info("info.log");
        logger.warn("warn.log");
        logger.error("error.log");
    }
}
