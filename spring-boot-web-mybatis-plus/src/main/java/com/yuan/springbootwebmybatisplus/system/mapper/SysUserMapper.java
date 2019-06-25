package com.yuan.springbootwebmybatisplus.system.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuan.springbootwebmybatisplus.commons.mapper.BaseMapper;
import com.yuan.springbootwebmybatisplus.system.entity.bo.SysUserQueryParams;
import com.yuan.springbootwebmybatisplus.system.entity.po.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @author yuane
 * @date 2019/6/20 23:02
 **/
@Repository
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {
    Page<Map<String, Object>> selectPageByQueryParams(IPage iPage, SysUserQueryParams queryParams);
}
