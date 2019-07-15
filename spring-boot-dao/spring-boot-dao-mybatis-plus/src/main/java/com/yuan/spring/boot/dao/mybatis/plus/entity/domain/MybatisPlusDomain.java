package com.yuan.spring.boot.dao.mybatis.plus.entity.domain;

import com.yuan.spring.boot.dao.commons.entity.domain.BaseDomain;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author yuane
 * @date 2019/6/15 23:28
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public abstract class MybatisPlusDomain<ID extends Serializable> extends BaseDomain<ID> implements Serializable, Cloneable {
    public MybatisPlusDomain() {
    }
}
