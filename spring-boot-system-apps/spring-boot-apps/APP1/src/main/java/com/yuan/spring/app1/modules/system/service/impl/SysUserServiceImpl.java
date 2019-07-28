package com.yuan.spring.app1.modules.system.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.QueryChainWrapper;
import com.yuan.spring.app1.modules.commons.service.impl.BaseServiceImpl;
import com.yuan.spring.app1.modules.commons.utils.PageVo;
import com.yuan.spring.app1.modules.system.dao.SysUserDao;
import com.yuan.spring.app1.modules.system.entity.converter.SysUserConverter;
import com.yuan.spring.app1.modules.system.entity.domain.SysUser;
import com.yuan.spring.app1.modules.system.entity.dto.SysUserQueryParams;
import com.yuan.spring.app1.modules.system.entity.vo.SysUserVo;
import com.yuan.spring.app1.modules.system.service.SysUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * @author yuane
 * @date 2019/7/27 11:09
 **/
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class SysUserServiceImpl extends BaseServiceImpl<SysUserDao, SysUser> implements SysUserService {
    private SysUserConverter sysUserConverter;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    public SysUserServiceImpl(SysUserConverter sysUserConverter) {
        this.sysUserConverter = sysUserConverter;
    }

    @Override
    public PageVo<SysUserVo> selectPage(SysUserQueryParams queryParams, Page<SysUser> page) {
        QueryChainWrapper<SysUser> query = query();
        IPage<SysUser> iPage = query.page(page);
        Page<SysUserVo> voPage = sysUserConverter.toVo((Page<SysUser>) iPage);
        PageVo<SysUserVo> pageVo = new PageVo<>();
        pageVo.setData(voPage.getRecords());
        pageVo.setTotal(iPage.getTotal());
        return pageVo;
    }

    @Override
    public List<SysUserVo> selectList(SysUserQueryParams queryParams) {
        QueryChainWrapper<SysUser> query = query();
        List<SysUser> list = query.list();
        return sysUserConverter.toVo(list);
    }

    @Override
    public SysUserVo selectOne(SysUserQueryParams queryParams) {
        return sysUserConverter.toVo(query().one());
    }

}
