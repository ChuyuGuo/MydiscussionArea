package com.mycode.SpringBootdemo.dao;/*
    @author 🐟🐟🐟
    @create 2022--04--12--15:48
*/

import com.mycode.SpringBootdemo.pojo.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
//此处的@Mapper是Mybatis的注解,与@Repository的最大区别就是@Mapper不需要扫描地址
//这里的@Mapper也是可以去掉的换成@Repository，但是要在启动类上加上@MapperScan(value = {"com.bf.spring4.mapper"})
@Mapper
public interface DiscussPostMapper {
    //当userId==0时,我就查询全部的帖子;有userId时就表示查询我的帖子
    //实现分页功能 offset表示显示行号,limit一页有多少行数据
    List<DiscussPost> selectDiscussPosts(int userId,int offset,int limit);

    //总页数 = 总数据行 / 单页的行数
    //@Param注解通常用于给参数去别名
    //如果只有一个参数,并且用在动态sql(比如说<if>里使用),则必须要有@Param注解
    int selectDiscussPostRows(@Param("userId") int userId);

}
