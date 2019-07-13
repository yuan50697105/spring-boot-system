package com.yuan.spring.boot.dao.mybatis.plus.commons.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yuane
 * @date 2019/7/13 11:53
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseVo<ID> implements Serializable {
    private ID id;
    private ID createUser;
    private ID updateUser;
    private Date createDate;
    private Date updateDate;
}
