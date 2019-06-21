package com.yuan.springbootwebjpa.system.service.impl;

import com.yuan.springbootwebjpa.commons.entity.dto.MapQuery;
import com.yuan.springbootwebjpa.commons.service.impl.BaseSerivceImpl;
import com.yuan.springbootwebjpa.system.entity.bo.SysRoleQueryParam;
import com.yuan.springbootwebjpa.system.entity.po.SysRole;
import com.yuan.springbootwebjpa.system.repository.SysRoleRepository;
import com.yuan.springbootwebjpa.system.service.SysRoleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author yuane
 * @date 2019/6/20 22:44
 **/
@Service
public class SysRoleServiceImpl extends BaseSerivceImpl<SysRole, String, SysRoleRepository> implements SysRoleService {
    private final SysRoleRepository sysRoleRepository;

    public SysRoleServiceImpl(SysRoleRepository sysRoleRepository) {
        this.sysRoleRepository = sysRoleRepository;
    }

    @Override
    protected SysRoleRepository getRepository() {
        return sysRoleRepository;
    }

    @Override
    public Page findPageByBo(SysRoleQueryParam sysRoleBo, Pageable pageable) {
        MapQuery baseQuery = createBaseQuery(sysRoleBo);
        return getRepository().findAllBySQL(baseQuery.getSql(), pageable, baseQuery.getMap());
    }

    @Override
    public List findListByBo(SysRoleQueryParam sysRoleBo) {
        MapQuery baseQuery = createBaseQuery(sysRoleBo);
        return getRepository().findAllBySQL(baseQuery.getSql(), baseQuery.getMap());
    }

    @Override
    public Optional findOneByBo(SysRoleQueryParam sysRoleBo) {
        MapQuery baseQuery = createBaseQuery(sysRoleBo);
        return getRepository().findOneBySQL(baseQuery.getSql(), baseQuery.getMap());
    }

    private MapQuery createBaseQuery(SysRoleQueryParam sysRoleBo) {
        Map<String, Object> map = sysRoleBo.toParamsMap();
        StringBuilder stringBuilder = new StringBuilder();
        return MapQuery.of(stringBuilder.toString(), map);
    }
}
