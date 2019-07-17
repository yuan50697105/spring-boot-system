package com.yuan.spring.boot.dao.nutz.service;

import com.yuan.spring.boot.dao.commons.service.BaseService;
import com.yuan.spring.boot.dao.nutz.entity.domain.NutzDomain;

import java.io.Serializable;

/**
 * @author yuane
 * @date 2019/7/18 0:23
 **/
public interface NutzService<T extends NutzDomain<ID>, ID extends Serializable> extends BaseService<T, ID> {
}
