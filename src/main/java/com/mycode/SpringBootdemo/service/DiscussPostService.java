package com.mycode.SpringBootdemo.service;/*
    @author 🐟🐟🐟
    @create 2022--04--12--16:27
*/

import com.mycode.SpringBootdemo.dao.DiscussPostMapper;
import com.mycode.SpringBootdemo.pojo.DiscussPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//目前还没有什么业务功能,所以该层没有添加上业务代码,但其实该业务层十分有必要
// 我们不能从controller层跨层调用DAO层
@Service
public class DiscussPostService {

    @Autowired
    private DiscussPostMapper discussPostMapper;

    public List<DiscussPost> findDiscussPosts(int userId, int offset, int limit) {
        return discussPostMapper.selectDiscussPosts(userId, offset, limit);
    }

    public int findDiscussPostRows(int userId) {
        return discussPostMapper.selectDiscussPostRows(userId);
    }

}
