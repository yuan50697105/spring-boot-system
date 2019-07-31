package com.yuan.spring.app1.modules.system.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuan.spring.app1.modules.commons.dao.BaseDao;
import com.yuan.spring.app1.modules.system.entity.domain.SysRole;
import com.yuan.spring.app1.modules.system.entity.dto.SysRoleQueryParams;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @author yuane
 * @date 2019/7/30 22:34
 **/
@Repository
@Mapper
public interface SysRoeDao extends BaseDao<SysRole> {
    Page<Map<String, Object>> selectPageByParams(Page page, SysRoleQueryParams queryParams);
}
