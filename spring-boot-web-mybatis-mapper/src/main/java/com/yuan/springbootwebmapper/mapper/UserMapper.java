package com.yuan.springbootwebmapper.mapper;

import com.yuan.springbootwebmapper.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author yuane
 * @date 2019/6/8 16:13
 **/
@Repository
@Mapper
public interface UserMapper extends tk.mybatis.mapper.common.Mapper<User>, MySqlMapper<User> {
}
