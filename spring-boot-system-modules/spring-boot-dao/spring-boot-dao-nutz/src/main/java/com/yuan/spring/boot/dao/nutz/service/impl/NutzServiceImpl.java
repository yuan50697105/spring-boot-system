package com.yuan.spring.boot.dao.nutz.service.impl;

import com.yuan.spring.boot.dao.nutz.dao.NutzDao;
import com.yuan.spring.boot.dao.nutz.entity.domain.NutzDomain;
import com.yuan.spring.boot.dao.nutz.service.NutzService;

import java.io.Serializable;

/**
 * @author yuane
 * @date 2019/7/18 0:23
 **/

public abstract class NutzServiceImpl<S extends NutzDao<T, ID>, T extends NutzDomain<ID>, ID extends Serializable> implements NutzService<T, ID> {
}
