package com.yuan.spring.boot.dao.mybatis.enhance.entity.domain;

import com.yuan.spring.boot.dao.commons.entity.domain.BaseDomain;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
public abstract class MybatisEnhanceDomain<ID extends Serializable> extends BaseDomain<ID> {
    public MybatisEnhanceDomain() {
    }
}
