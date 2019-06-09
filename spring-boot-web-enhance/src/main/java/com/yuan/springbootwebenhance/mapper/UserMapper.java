package com.yuan.springbootwebenhance.mapper;

import com.gitee.hengboy.mybatis.enhance.mapper.EnhanceMapper;
import com.yuan.springbootwebenhance.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yuane
 * @date 2019/6/9 22:37
 **/
@Repository
@Mapper
public interface UserMapper extends EnhanceMapper<User, String> {
    List<User> selectAll();
}
