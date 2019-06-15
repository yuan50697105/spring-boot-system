package com.yuan.springbootwebmybatis.mapper;

import com.yuan.springbootwebmybatis.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yuane
 * @date 2019/6/8 16:13
 **/
@Repository
@Mapper
public interface UserMapper {
    int insert(User user);

    List<User> selectAll();
}
