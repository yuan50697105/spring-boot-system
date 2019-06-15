package com.yuan.springbootwebjooq.dao;


import com.yuan.springbootwebjooq.entity.User;
import org.jooq.Record;
import org.jooq.Result;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author yuane
 * @date 2019/6/8 16:59
 **/
public interface UserDao {
    void insert(User user);

    @Transactional
    Result<Record> selectAll();

    void testDelete();
}
