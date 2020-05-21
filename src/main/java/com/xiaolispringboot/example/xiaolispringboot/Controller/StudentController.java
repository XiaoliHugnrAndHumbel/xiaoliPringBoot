package com.xiaolispringboot.example.xiaolispringboot.Controller;

import com.alibaba.fastjson.JSONObject;
import com.xiaolispringboot.example.xiaolispringboot.Service.StudentService;
import com.xiaolispringboot.example.xiaolispringboot.model.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    @Autowired(required = false)
    private StudentService studentService;
    @RequestMapping("/hello")
    public String index(){
        return "Hello World";
    }

       @RequestMapping("/get")
       @ResponseBody//让controller返回数据能够在页面上显示，实现回显效果
    public String get(Student student){
        Student stu=studentService.getNamebyId(student);
        return JSONObject.toJSONString(stu);
    }
}
