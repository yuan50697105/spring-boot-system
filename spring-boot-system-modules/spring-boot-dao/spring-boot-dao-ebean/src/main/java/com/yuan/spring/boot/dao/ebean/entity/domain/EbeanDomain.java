package com.yuan.spring.boot.dao.ebean.entity.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * @author yuane
 * @date 2019/7/13 12:22
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@MappedSuperclass
public abstract class EbeanDomain<ID extends Serializable> extends com.yuan.spring.boot.dao.commons.entity.domain.BaseDomain<ID> {
    public EbeanDomain() {
    }
}
