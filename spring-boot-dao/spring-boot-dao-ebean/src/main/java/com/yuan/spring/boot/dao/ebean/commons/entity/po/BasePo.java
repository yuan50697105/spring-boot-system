package com.yuan.spring.boot.dao.ebean.commons.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BasePo<ID> {
    private ID id;
    private String createUser;
    private String updateUser;
    private Date createDate;
    private Date updateDate;

}
