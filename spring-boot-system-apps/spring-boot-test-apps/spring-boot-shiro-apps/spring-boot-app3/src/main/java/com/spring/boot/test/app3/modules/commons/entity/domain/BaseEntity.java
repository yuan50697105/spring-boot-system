package com.spring.boot.test.app3.modules.commons.entity.domain;

import com.yuan.spring.boot.dao.mybatis.mapper.entity.domain.MybatisMapperDomain;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
@Data
public class BaseEntity extends MybatisMapperDomain<Long> {
    @Id
    private Long id;
    private Long crateBy;
    private Long modifyBy;
    private Date createDate;
    private Date modifyDate;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
