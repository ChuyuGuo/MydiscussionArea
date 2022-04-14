package com.mycode.SpringBootdemo.pojo;/*
    @author 🐟🐟🐟
    @create 2022--04--12--15:42
*/

import lombok.Data;

import java.util.Date;

//注意对象属性名要和数据库字段名一致(除了命名规范、驼峰命名与下划线命名)
@Data
public class DiscussPost {
    private int id; //帖子id
    private int userId; //帖主id
    private String title;   //帖子标题
    private String content; //帖主内容
    private int type;   //帖子内容(0是普通,1是置顶)
    private int status; //帖子状态(0是正常,1是精华,2是拉黑)
    private Date createTime;   //创建时间
    private int commentCount;   //评论数
    private double score; //帖子的分数
}
