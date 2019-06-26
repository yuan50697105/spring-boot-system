package com.yuan.springbootwebjpa.system.service;

import com.yuan.springbootwebjpa.commons.service.BaseSerivce;
import com.yuan.springbootwebjpa.system.entity.bo.SysResourceQueryParam;
import com.yuan.springbootwebjpa.system.entity.po.SysResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * @author yuane
 * @date 2019/6/20 22:48
 **/
public interface SysResourceService extends BaseSerivce<SysResource, Long> {
    Page findPageByQueryParams(SysResourceQueryParam queryParam, Pageable pageable);

    List findPageByQueryParams(SysResourceQueryParam queryParam);

    Optional findOneByQueryParams(SysResourceQueryParam queryParam);
}
