package com.yuan.springbootwebjpa.system.repository;

import com.yuan.springbootwebjpa.commons.repository.BaseRepository;
import com.yuan.springbootwebjpa.system.entity.po.SysResource;
import org.springframework.stereotype.Repository;

/**
 * @author yuane
 * @date 2019/6/20 22:42
 **/
@Repository
public interface SysResourceRepository extends BaseRepository<SysResource, Long> {
}
