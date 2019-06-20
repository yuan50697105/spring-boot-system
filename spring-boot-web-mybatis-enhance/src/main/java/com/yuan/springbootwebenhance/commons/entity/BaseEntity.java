package com.yuan.springbootwebenhance.commons.entity;

import com.gitee.hengboy.mybatis.enhance.common.annotation.Id;
import lombok.Data;

import java.io.Serializable;

/**
 * @author yuane
 * @date 2019/6/15 22:21
 **/
@Data
public class BaseEntity implements Serializable {
    @Id
    private String id;
}
