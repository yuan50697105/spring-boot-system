package com.yuan.springbootwebjpa.system.service.impl;

import com.yuan.springbootwebjpa.commons.entity.dto.MapQuery;
import com.yuan.springbootwebjpa.commons.service.impl.BaseSerivceImpl;
import com.yuan.springbootwebjpa.system.entity.bo.SysUserQueryParam;
import com.yuan.springbootwebjpa.system.entity.po.SysUser;
import com.yuan.springbootwebjpa.system.repository.SysUserRepository;
import com.yuan.springbootwebjpa.system.service.SysUserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author yuane
 * @date 2019/6/20 22:32
 **/
@Service
public class SysUserServiceImpl extends BaseSerivceImpl<SysUser, Long, SysUserRepository> implements SysUserService {
    private final SysUserRepository sysUserRepository;

    public SysUserServiceImpl(SysUserRepository sysUserRepository) {
        this.sysUserRepository = sysUserRepository;
    }

    @Override
    protected SysUserRepository getRepository() {
        return sysUserRepository;
    }

    @Override
    public Page findPageByBo(SysUserQueryParam sysUserBo, Pageable pageable) {
        MapQuery baseQuery = createBaseQuery(sysUserBo);
        return getRepository().findAllBySQL(baseQuery.getSql(), pageable, baseQuery.getMap());
    }

    @Override
    public List findListByBo(SysUserQueryParam sysUserBo) {
        MapQuery baseQuery = createBaseQuery(sysUserBo);
        return getRepository().findAllBySQL(baseQuery.getSql(), baseQuery.getMap());
    }

    @Override
    public Optional findOneByBo(SysUserQueryParam sysUserBo) {
        MapQuery baseQuery = createBaseQuery(sysUserBo);
        return getRepository().findOneBySQL(baseQuery.getSql(), baseQuery.getMap());
    }

    private MapQuery createBaseQuery(SysUserQueryParam sysUserBo) {
        StringBuilder stringBuilder = new StringBuilder();

        Map<String, Object> map = sysUserBo.toParamsMap();
        return MapQuery.of(stringBuilder.toString(), map);
    }
}
