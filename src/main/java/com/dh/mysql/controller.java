package com.dh.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class controller {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @ResponseBody
    @RequestMapping("add/{name}/{sex}/{age}")
    public String add(@PathVariable("name")String name,@PathVariable("sex")String sex,@PathVariable("age")int age){
        jdbcTemplate.execute("insert into user values ('"+name+"','"+sex+"','"+age+"')");
        return "添加成功";
    }

    @ResponseBody
    @RequestMapping("delete/{name}")
    public String delete(@PathVariable("name")String name){
        jdbcTemplate.execute("delete from user where name='"+name+"'");
        return "删除成功";
    }

    @ResponseBody
    @RequestMapping("update/{name}/{age}")
    public String update(@PathVariable("name")String name,@PathVariable("age")int age){
        jdbcTemplate.execute("update user set age='"+age+"'where name='"+name+"'");
        return "修改成功";
    }


    @ResponseBody
    @RequestMapping("query/{name}")
    public Object query(@PathVariable("name")String name){

        List list=jdbcTemplate.queryForList("select * from user where name='"+name+"'");
        return list.get(0);
    }




}
