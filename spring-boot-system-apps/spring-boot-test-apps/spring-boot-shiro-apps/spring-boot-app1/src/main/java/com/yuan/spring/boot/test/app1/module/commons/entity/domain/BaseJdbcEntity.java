package com.yuan.spring.boot.test.app1.module.commons.entity.domain;

import com.yuan.spring.boot.dao.jdbc.entity.domain.JdbcDomain;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.MappedSuperclass;

/**
 * @author yuane
 * @date 2019/7/22 18:33
 **/
@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
@Data
public class BaseJdbcEntity extends JdbcDomain<Long> {
    private Long id;
}
