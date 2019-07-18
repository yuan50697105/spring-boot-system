package com.yuan.spring.boot.dao.jpa.service;

import com.yuan.spring.boot.dao.jpa.entity.domain.JpaDomain;

import java.io.Serializable;

/**
 * @author yuane
 * @date 2019/6/15 19:07
 **/
public interface JpaService<T extends JpaDomain<ID>, ID extends Serializable> extends com.yuan.spring.boot.dao.commons.service.BaseService<T, ID> {

}
