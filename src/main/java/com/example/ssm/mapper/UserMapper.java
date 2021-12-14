package com.example.ssm.mapper;

import com.example.ssm.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> findAll();
    int save(User user);
    int deleteUser(Integer id);
    int updateUser(User user);
    User findOne(Integer id);
}
