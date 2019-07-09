package com.yuan.spring.boot.mybatis.plus.commons.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author yuane
 * @date 2019/7/1 22:31
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseVo {
    private String id;
    private String createUser;
    private String updateUser;
    private Date createDate;
    private Date updateDate;

}
