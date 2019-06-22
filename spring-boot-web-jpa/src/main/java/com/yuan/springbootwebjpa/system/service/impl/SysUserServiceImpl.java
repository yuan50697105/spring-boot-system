package com.yuan.springbootwebjpa.system.service.impl;

import com.yuan.springbootwebjpa.commons.entity.dto.MapQuery;
import com.yuan.springbootwebjpa.commons.service.impl.BaseServiceImpl;
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
public class SysUserServiceImpl extends BaseServiceImpl<SysUser, Long, SysUserRepository> implements SysUserService {
    private final SysUserRepository sysUserRepository;

    public SysUserServiceImpl(SysUserRepository sysUserRepository) {
        this.sysUserRepository = sysUserRepository;
    }

    @Override
    protected SysUserRepository getRepository() {
        return sysUserRepository;
    }

    @Override
    public Page findPageByParams(SysUserQueryParam sysUserBo, Pageable pageable) {
        return findAllBySQLToMap(createBaseQuery(sysUserBo), pageable);
    }

    @Override
    public List findListByParams(SysUserQueryParam sysUserBo) {
        return findAllBySQLToMap(createBaseQuery(sysUserBo));
    }

    @Override
    public Optional findOneByParams(SysUserQueryParam sysUserBo) {
        return findOneBySQL(createBaseQuery(sysUserBo));
    }

    private MapQuery createBaseQuery(SysUserQueryParam sysUserBo) {
        StringBuilder stringBuilder = new StringBuilder();
        Map<String, Object> map = sysUserBo.toParamsMap();

        return MapQuery.of(stringBuilder.toString(), map);
    }
}
