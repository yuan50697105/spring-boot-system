package com.yuan.spring.boot.dao.mybatis.entity.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * @author yuane
 * @date 2019/7/10 22:33
 **/
@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
@Data
public abstract class MybatisDomain<ID extends Serializable> extends com.yuan.spring.boot.dao.commons.entity.domain.BaseDomain<ID>  {
    public MybatisDomain() {
    }

    public MybatisDomain(ID id) {
        super(id);
    }
}
