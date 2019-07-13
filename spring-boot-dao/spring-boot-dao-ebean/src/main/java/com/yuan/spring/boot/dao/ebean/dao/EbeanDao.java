package com.yuan.spring.boot.dao.ebean.dao;

import com.yuan.spring.boot.dao.ebean.entity.domain.EbeanDomain;
import org.springframework.data.ebean.repository.EbeanRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * @author yuane
 * @date 2019/7/13 12:36
 **/
@NoRepositoryBean
public interface EbeanDao<T extends EbeanDomain<ID>, ID extends Serializable> extends EbeanRepository<T, ID> {
}
