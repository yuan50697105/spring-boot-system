package com.yuan.spring.boot.dao.nutz.entity.domain;

import com.yuan.spring.boot.dao.commons.entity.domain.BaseDomain;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author yuane
 * @date 2019/7/17 23:48
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public abstract class NutzDomain<ID extends Serializable> extends BaseDomain<ID> {
}
