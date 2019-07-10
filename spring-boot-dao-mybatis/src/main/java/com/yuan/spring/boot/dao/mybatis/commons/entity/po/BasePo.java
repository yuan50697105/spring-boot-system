package com.yuan.spring.boot.dao.mybatis.commons.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

/**
 * @author yuane
 * @date 2019/7/10 22:33
 **/
@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class BasePo<ID> implements Serializable {
    @Id
    private ID id;
    private String createUser;
    private String updateUser;
    private Date createDate;
    private Date updateDate;
}
