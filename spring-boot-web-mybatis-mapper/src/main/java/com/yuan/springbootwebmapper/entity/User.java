package com.yuan.springbootwebmapper.entity;

import com.yuan.springbootwebmapper.utils.MyGenSql;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author yuane
 * @date 2019/6/8 16:12
 **/
@Data
@Table(name = "user")
public class User {
    @Id
    @KeySql(genId = MyGenSql.class)
    private String id;
    private String name;
}
