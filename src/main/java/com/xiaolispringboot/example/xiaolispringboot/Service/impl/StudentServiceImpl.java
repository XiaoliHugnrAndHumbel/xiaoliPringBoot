package com.xiaolispringboot.example.xiaolispringboot.Service.impl;

import com.xiaolispringboot.example.xiaolispringboot.Service.StudentService;
import com.xiaolispringboot.example.xiaolispringboot.mapper.StudentMapper;
import com.xiaolispringboot.example.xiaolispringboot.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
   @Autowired
   private StudentMapper studentMapper;

    @Override
    public Student getNamebyId(Student student) {
        System.out.println(student.toString());
        return studentMapper.getNameByid(student);
    }
}
