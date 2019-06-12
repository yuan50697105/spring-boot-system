package com.yuan.springbootwebjdbc.dao;

import com.yuan.springbootwebjdbc.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CrudRepository<User, String> {
}
