package com.yuan.spring.boot.dao.ebean.commons.dao;

import com.yuan.spring.boot.dao.ebean.commons.entity.po.BasePo;
import org.springframework.data.ebean.repository.EbeanRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author yuane
 * @date 2019/7/10 23:37
 **/
@NoRepositoryBean
public interface BaseDao<T extends BasePo<ID>, ID> extends EbeanRepository<T, ID> {
}
