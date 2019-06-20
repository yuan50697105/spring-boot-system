package com.yuan.springbootwebjpa.system.repository;

import com.yuan.springbootwebjpa.commons.repository.BaseRepository;
import com.yuan.springbootwebjpa.system.entity.po.SysRoleResource;
import org.springframework.stereotype.Repository;

/**
 * @author yuane
 * @date 2019/6/20 22:50
 **/
@Repository
public interface SysRoleResourceRepository extends BaseRepository<SysRoleResource, Long> {
}
