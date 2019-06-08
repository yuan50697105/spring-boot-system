package com.yuan.springbootwebmybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yuan.springbootwebmybatisplus.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author yuane
 * @date 2019/6/8 16:13
 **/
@Repository
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
