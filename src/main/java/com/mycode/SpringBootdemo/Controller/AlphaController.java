package com.mycode.SpringBootdemo.Controller;/*
    @author 🐟🐟🐟
    @create 2022--04--07--16:48
*/

import com.mycode.SpringBootdemo.service.AplhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@Controller
@RequestMapping("/alpha")
public class AlphaController {
    @Autowired
    private AplhaService aplhaService;

    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello(){
        return "Hello Spring Boot";
    }

    @RequestMapping("/dao")
    @ResponseBody
    public String getdata(){
        return aplhaService.find();
    }

    //获得请求响应对象
    @RequestMapping("/http")
    public void http(HttpServletRequest request, HttpServletResponse response){
        System.out.println(request.getMethod());
        System.out.println(request.getServletPath());
        Enumeration<String> headerNames = request.getHeaderNames();
        //迭代器
        while(headerNames.hasMoreElements()){
            String name = headerNames.nextElement();
            String value = request.getHeader(name);
            System.out.println(name+":"+value);
        }

        //返回响应数据
        response.setContentType("text/html;charset=utf-8");
        try (PrintWriter writer = response.getWriter()) {
            writer.write("<h1>牛客网</h1>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //RequestMapping有很多种用户,可以指定参数,请求方法
    @RequestMapping(path = "/students",method = RequestMethod.GET)
    @ResponseBody
    public String getTest(@RequestParam(name = "current",required = false,defaultValue = "1") int current,
            @RequestParam(name = "limit",required = false,defaultValue = "10") int limit){
        System.out.println(current);
        System.out.println(limit);
        return "some students";
    }

    //  "/student/123"  (Restful风格)
    @RequestMapping(path = "/student/{id}",method = RequestMethod.GET)
    @ResponseBody
    public String getStudent(@PathVariable("id") int id){
        System.out.println(id);
        return "a student";
    }

    //Post
    @RequestMapping(path = "/student",method = RequestMethod.POST)
    @ResponseBody
    public String saveStudent(String uname,String upwd){
        System.out.println(uname);
        System.out.println(upwd);
        return "success";
    }

    //响应HTML数据(一种返回网页的方法）
    @RequestMapping(path = "/teacher",method = RequestMethod.GET)
    public ModelAndView getTeacher(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("name","张三");
        mv.addObject("age",30);
        mv.setViewName("/demo/view");
        return mv;
    }
    //第二种返回方式
    @RequestMapping(path = "/school",method = RequestMethod.GET)
    public String getSchool(Model model){
        model.addAttribute("name","广东技术师范大学");
        model.addAttribute("age",500);
        return "/demo/view";
    }

    //响应JSON(异步请求) '{"key":"value"}' '["key":"value"]'
    @RequestMapping(path = "/emp",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getEmp(){
        Map<String,Object> emp = new HashMap<>();
        emp.put("name","张三");
        emp.put("age","32");
        emp.put("sex","男");
        return emp; //默认会以JSON字符串形式返回数据
    }

    //响应JSON(异步请求) '{"key":"value"}' '["key":"value"]'
    @RequestMapping(path = "/emps",method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String,Object>> getEmps(){
        List<Map<String, Object>> list = new ArrayList<>();

        Map<String,Object> emp1 = new HashMap<>();
        emp1.put("name","张三");
        emp1.put("age","32");
        emp1.put("sex","男");
        list.add(emp1);

        Map<String,Object> emp2 = new HashMap<>();
        emp2.put("name","徐日山");
        emp2.put("age","97");
        emp2.put("sex","女");
        list.add(emp2);

        Map<String,Object> emp3 = new HashMap<>();
        emp3.put("name","雷雨龙");
        emp3.put("age","00");
        emp3.put("sex","男");
        list.add(emp3);

        return list; //默认会以JSON字符串形式返回数据
    }
}
