package com.yuan.springbootwebjpa.system.repository;

import com.yuan.springbootwebjpa.commons.repository.BaseRepository;
import com.yuan.springbootwebjpa.system.entity.po.SysUserRole;
import org.springframework.stereotype.Repository;

/**
 * @author yuane
 * @date 2019/6/20 22:42
 **/
@Repository
public interface SysUserRoleRepository extends BaseRepository<SysUserRole, Long> {
}
