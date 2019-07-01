package com.yuan.springbootwebmybatisplus.system.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuan.springbootwebmybatisplus.commons.mapper.BaseMapper;
import com.yuan.springbootwebmybatisplus.system.entity.bo.SysUserQueryParams;
import com.yuan.springbootwebmybatisplus.system.entity.po.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author yuane
 * @date 2019/6/29 14:18
 **/
@Repository
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {
    int countByUsername(String username);

    Page<Map<String, Object>> findPageByQueryParams(Page<Map<String, Object>> mapPage, @Param("queryParams") SysUserQueryParams queryParams);

    List<Map<String, Object>> findListByQueryParams(@Param("queryParams") SysUserQueryParams queryParams);
}
