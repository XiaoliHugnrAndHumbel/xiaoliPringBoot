package com.xiaolispringboot.example.xiaolispringboot.Controller;

import com.alibaba.fastjson.JSONObject;
import com.xiaolispringboot.example.xiaolispringboot.Service.StudentService;
import com.xiaolispringboot.example.xiaolispringboot.mapper.QuestionMapper;
import com.xiaolispringboot.example.xiaolispringboot.model.Question;
import com.xiaolispringboot.example.xiaolispringboot.model.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {
    @Autowired(required = false)
    private StudentService studentService;
@Autowired
private QuestionMapper questionMapper;
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
    @RequestMapping("/getAllQuestion")
    @ResponseBody
    public  String getQuestion(){
      Question question=questionMapper.selectByPrimaryKey(1);
        List<Question> questionList=questionMapper.selectAll();
        return  JSONObject.toJSONString(questionList);
    }
}
