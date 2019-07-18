package com.yuan.spring.boot.jooq.entity.domain;

import com.yuan.spring.boot.dao.commons.entity.domain.BaseDomain;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author yuane
 * @date 2019/7/18 22:11
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public abstract class JooqDomain<ID extends Serializable> extends BaseDomain<ID> {
    public JooqDomain() {
    }
}
