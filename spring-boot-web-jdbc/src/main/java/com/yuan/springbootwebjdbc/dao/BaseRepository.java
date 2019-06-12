package com.yuan.springbootwebjdbc.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<T,ID> extends CrudRepository<T,ID> {
}
