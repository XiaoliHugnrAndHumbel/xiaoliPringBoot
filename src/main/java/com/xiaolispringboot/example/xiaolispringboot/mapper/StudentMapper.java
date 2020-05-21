package com.xiaolispringboot.example.xiaolispringboot.mapper;

import com.xiaolispringboot.example.xiaolispringboot.model.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface StudentMapper {
//    @Select("select * from ")
    public Student getNameByid(Student studen);
}
