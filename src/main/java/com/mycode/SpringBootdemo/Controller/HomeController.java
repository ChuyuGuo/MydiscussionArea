package com.mycode.SpringBootdemo.Controller;/*
    @author 🐟🐟🐟
    @create 2022--04--12--16:39
*/

import com.mycode.SpringBootdemo.pojo.DiscussPost;
import com.mycode.SpringBootdemo.pojo.Page;
import com.mycode.SpringBootdemo.pojo.User;
import com.mycode.SpringBootdemo.service.DiscussPostService;
import com.mycode.SpringBootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {
    @Autowired
    private DiscussPostService discussPostService;

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/index",method = RequestMethod.GET)
    public String getIndexPage(Model model, Page page){
        //Spring MVC中所有数据都是有DispatcherServlet管理的
        //方法调用前,Spring MVC会自动实例化Model和Page并将Page注入Model
        page.setRows(discussPostService.findDiscussPostRows(0));
        page.setPath("/index");     //获取当前页面
        List<DiscussPost> list = discussPostService.findDiscussPosts(0, page.getOffset(), page.getLimit());
        List<Map<String,Object>> discussPosts = new ArrayList<>();
        //组合数据,用户不能知道userId,只能知道对应的userName
        if(list != null){
            for (DiscussPost post : list) {
                Map<String,Object> map = new HashMap<>();
                map.put("post",post);
                User user = userService.findUserById(post.getUserId());
                map.put("user",user);
                discussPosts.add(map);
            }
        }
        //将数据添加到model层
        model.addAttribute("discussPosts",discussPosts);
        return "/index";    //跳转的视图页面路径
    }

}
