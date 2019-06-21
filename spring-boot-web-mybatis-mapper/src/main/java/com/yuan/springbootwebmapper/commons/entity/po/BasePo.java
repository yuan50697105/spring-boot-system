package com.yuan.springbootwebmapper.commons.entity.po;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.genid.GenId;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * @author yuane
 * @date 2019/6/15 22:47
 **/
@Data
@MappedSuperclass
public abstract class BasePo implements Serializable, GenId<String> {
    @Id
    @KeySql(genId = BasePo.class)
    private String id;
    private String createUser;
    private String updateUser;
    private Date createDate;
    private Date updateDate;

    @Override
    public String genId(String table, String column) {
        return UUID.randomUUID().toString();
    }
}
