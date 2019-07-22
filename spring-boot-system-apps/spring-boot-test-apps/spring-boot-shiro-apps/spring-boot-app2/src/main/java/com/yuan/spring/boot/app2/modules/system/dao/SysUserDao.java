package com.yuan.spring.boot.app2.modules.system.dao;

import com.yuan.spring.boot.app2.modules.commons.dao.BaseDao;
import com.yuan.spring.boot.app2.modules.system.entity.domain.SysUser;
import com.yuan.spring.boot.app2.modules.system.entity.dto.SysUserQueryParams;
import com.yuan.spring.boot.app2.modules.system.entity.dto.SysUserQueryResult;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yuane
 * @date 2019/7/22 23:03
 **/
@Repository
@Mapper
public interface SysUserDao extends BaseDao<SysUser> {
    List<SysUserQueryResult> selectQueryResultListByParams(SysUserQueryParams queryParams);
}
