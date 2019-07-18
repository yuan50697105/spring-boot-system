package com.yuan.spring.boot.dao.ebean.service;

import com.yuan.spring.boot.dao.ebean.entity.domain.EbeanDomain;

import java.io.Serializable;

/**
 * @author yuane
 * @date 2019/7/13 12:37
 **/
public interface EbeanService<T extends EbeanDomain<ID>, ID extends Serializable> extends com.yuan.spring.boot.dao.commons.service.BaseService<T, ID> {


}
