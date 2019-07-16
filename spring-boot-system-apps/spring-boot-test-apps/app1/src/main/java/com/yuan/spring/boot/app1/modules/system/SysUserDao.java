package com.yuan.spring.boot.app1.modules.system;

import com.yuan.spring.boot.app1.modules.commons.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author yuane
 * @date 2019/7/16 21:07
 **/
@Repository
@Mapper
public interface SysUserDao extends BaseDao<SysUser> {
}
