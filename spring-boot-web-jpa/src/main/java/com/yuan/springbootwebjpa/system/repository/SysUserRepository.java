package com.yuan.springbootwebjpa.system.repository;

import com.yuan.springbootwebjpa.commons.repository.BaseRepository;
import com.yuan.springbootwebjpa.system.entity.po.SysUser;
import org.springframework.stereotype.Repository;

/**
 * @author yuane
 * @date 2019/6/20 22:33
 **/
@Repository
public interface SysUserRepository extends BaseRepository<SysUser, Long> {
}
