package com.yuan.springbootwebenhance.entity;

import com.gitee.hengboy.mybatis.enhance.common.annotation.Id;
import com.gitee.hengboy.mybatis.enhance.common.annotation.Table;
import com.gitee.hengboy.mybatis.enhance.common.enums.KeyGeneratorTypeEnum;
import lombok.Data;

/**
 * @author yuane
 * @date 2019/6/9 22:35
 **/
@Table(name = "user")
@Data
public class User {
    @Id(generatorType = KeyGeneratorTypeEnum.DIY)
    private String id;
    private String name;
}
