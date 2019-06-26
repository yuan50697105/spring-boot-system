package com.yuan.springbootwebjpa.system.service.impl;

import com.yuan.springbootwebjpa.commons.entity.dto.MapQuery;
import com.yuan.springbootwebjpa.commons.service.impl.BaseServiceImpl;
import com.yuan.springbootwebjpa.system.entity.bo.SysResourceQueryParam;
import com.yuan.springbootwebjpa.system.entity.po.SysResource;
import com.yuan.springbootwebjpa.system.repository.SysResourceRepository;
import com.yuan.springbootwebjpa.system.service.SysResourceService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author yuane
 * @date 2019/6/20 22:48
 **/
@Service
public class SysResourceServiceImpl extends BaseServiceImpl<SysResource, Long, SysResourceRepository> implements SysResourceService {
    private final SysResourceRepository sysResourceRepository;

    public SysResourceServiceImpl(SysResourceRepository sysResourceRepository) {
        this.sysResourceRepository = sysResourceRepository;
    }

    @Override
    protected SysResourceRepository getRepository() {
        return sysResourceRepository;
    }

    @Override
    public Page findPageByQueryParams(SysResourceQueryParam queryParam, Pageable pageable) {
        return sysResourceRepository.findAllBySQLQueryToMap(createByMapQuery(queryParam), pageable);
    }

    @Override
    public List findPageByQueryParams(SysResourceQueryParam queryParam) {
        return sysResourceRepository.findAllBySQLQueryToMap(createByMapQuery(queryParam));
    }

    @Override
    public Optional findOneByQueryParams(SysResourceQueryParam queryParam) {
        return sysResourceRepository.findOneBySQLQueryToMap(createByMapQuery(queryParam));
    }

    private MapQuery createByMapQuery(SysResourceQueryParam queryParam) {
        StringBuilder stringBuilder = new StringBuilder();
        Map<String, Object> paramsMap = queryParam.toParamsMap();
        return MapQuery.of(stringBuilder.toString(), paramsMap);
    }
}
