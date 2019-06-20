package com.yuan.springbootwebjpa.system.repository;

import com.yuan.springbootwebjpa.commons.repository.BaseRepository;
import com.yuan.springbootwebjpa.system.entity.po.SysRole;
import org.springframework.stereotype.Repository;

/**
 * @author yuane
 * @date 2019/6/20 22:41
 **/
@Repository
public interface SysRoleRepository extends BaseRepository<SysRole, Long> {
}
