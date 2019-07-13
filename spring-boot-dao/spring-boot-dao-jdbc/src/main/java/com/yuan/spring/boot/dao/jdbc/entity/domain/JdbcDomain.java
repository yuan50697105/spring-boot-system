package com.yuan.spring.boot.dao.jdbc.entity.domain;

import com.yuan.spring.boot.dao.commons.entity.domain.BaseDomain;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author yuane
 * @date 2019/7/13 21:59
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public abstract class JdbcDomain<ID extends Serializable> extends BaseDomain<ID> {
}
