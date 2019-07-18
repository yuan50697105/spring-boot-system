package com.yuan.spring.boot.dao.jpa.entity.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author yuane
 * @date 2019/7/13 14:14
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public abstract class JpaVo<ID extends Serializable> extends com.yuan.spring.boot.dao.commons.entity.vo.BaseVo<ID> {
    public JpaVo() {
    }

    public JpaVo(ID id) {
        super(id);
    }
}
