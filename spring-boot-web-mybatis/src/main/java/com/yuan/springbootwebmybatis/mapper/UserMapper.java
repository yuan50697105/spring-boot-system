package com.yuan.springbootwebmybatis.mapper;

import com.yuan.springbootwebmybatis.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author yuane
 * @date 2019/6/8 16:13
 **/
@Repository
@Mapper
public interface UserMapper {
    public int insert(User user);
}
