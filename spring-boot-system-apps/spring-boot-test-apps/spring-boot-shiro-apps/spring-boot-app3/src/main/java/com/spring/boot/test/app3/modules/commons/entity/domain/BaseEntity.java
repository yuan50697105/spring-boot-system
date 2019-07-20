package com.spring.boot.test.app3.modules.commons.entity.domain;

import com.yuan.spring.boot.dao.mybatis.mapper.entity.domain.MybatisMapperDomain;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.MappedSuperclass;

@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
@Data
public class BaseEntity extends MybatisMapperDomain<Long> {
    private Long id;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
