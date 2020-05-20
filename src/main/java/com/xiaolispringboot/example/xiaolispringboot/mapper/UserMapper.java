package com.xiaolispringboot.example.xiaolispringboot.mapper;

import com.xiaolispringboot.example.xiaolispringboot.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    @Insert("insert into user (name,account_id,token,gmt_create,gmt_modified) values(#{name},#{accountId},#{token},#{gmtCreat},#{gmtModified})")
    void Insert(User user);
}
