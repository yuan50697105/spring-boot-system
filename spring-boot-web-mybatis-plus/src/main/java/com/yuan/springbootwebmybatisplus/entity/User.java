package com.yuan.springbootwebmybatisplus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author yuane
 * @date 2019/6/8 16:12
 **/
@Data
@TableName("user")
public class User {
    private String id;
    private String name;
}
