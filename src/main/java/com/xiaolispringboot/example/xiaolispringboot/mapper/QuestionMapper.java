package com.xiaolispringboot.example.xiaolispringboot.mapper;

import com.common.mybatis.MyMapper;
import com.xiaolispringboot.example.xiaolispringboot.model.Question;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;


@Mapper
@Component
public interface QuestionMapper extends MyMapper<Question> {
    int deleteByPrimaryKey(Integer id);

    int insert(Question record);

    int insertSelective(Question record);

    Question selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Question record);

    int updateByPrimaryKeyWithBLOBs(Question record);

    int updateByPrimaryKey(Question record);
}