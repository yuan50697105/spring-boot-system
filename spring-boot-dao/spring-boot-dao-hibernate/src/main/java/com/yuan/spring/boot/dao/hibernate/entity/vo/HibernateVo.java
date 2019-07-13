package com.yuan.spring.boot.dao.hibernate.entity.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author yuane
 * @date 2019/7/13 14:14
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public abstract class HibernateVo<ID extends Serializable> extends com.yuan.spring.boot.dao.commons.entity.vo.BaseVo<ID> {
    public HibernateVo() {
    }

    public HibernateVo(ID id) {
        super(id);
    }
}
