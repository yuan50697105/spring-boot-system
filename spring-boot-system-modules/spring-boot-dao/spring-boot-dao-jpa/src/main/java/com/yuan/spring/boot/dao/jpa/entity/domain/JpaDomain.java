package com.yuan.spring.boot.dao.jpa.entity.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * @author yuane
 * @date 2019/6/15 17:03
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@MappedSuperclass
public abstract class JpaDomain<ID extends Serializable> extends com.yuan.spring.boot.dao.commons.entity.domain.BaseDomain<ID> implements Serializable {
    public JpaDomain() {
    }
}
