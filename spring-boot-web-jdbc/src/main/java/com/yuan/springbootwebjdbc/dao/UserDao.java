package com.yuan.springbootwebjdbc.dao;

import com.yuan.springbootwebjdbc.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserDao extends CrudRepository<User, String> {
}
