package com.yuan.spring.boot.app.modules.commons.entity.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.yuan.spring.boot.dao.mybatis.plus.entity.domain.MybatisPlusDomain;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author yuane
 * @date 2019/7/13 1:12
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public abstract class BaseDomain extends MybatisPlusDomain<String> {
    @TableId(type = IdType.UUID)
    private String id;

    public BaseDomain() {
    }

    public BaseDomain(String id, String createUser, String updateUser, Date createDate, Date updateDate) {
        super(createUser, updateUser, createDate, updateDate);
        this.id = id;
    }
}
