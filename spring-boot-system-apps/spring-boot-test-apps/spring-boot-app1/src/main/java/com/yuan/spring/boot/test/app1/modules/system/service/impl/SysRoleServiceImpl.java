package com.yuan.spring.boot.test.app1.modules.system.service.impl;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import cn.afterturn.easypoi.excel.entity.result.ExcelVerifyHandlerResult;
import cn.afterturn.easypoi.handler.inter.IExcelVerifyHandler;
import cn.hutool.core.util.ObjectUtil;
import com.yuan.spring.boot.dao.commons.entity.dto.ServiceResult;
import com.yuan.spring.boot.dao.commons.exception.CheckNotPassException;
import com.yuan.spring.boot.dao.commons.utils.CheckMessageUtils;
import com.yuan.spring.boot.dao.commons.utils.ServiceResultUtils;
import com.yuan.spring.boot.test.app1.modules.commons.service.impl.AbstractCommonsServiceImpl;
import com.yuan.spring.boot.test.app1.modules.system.dao.SysRoleDao;
import com.yuan.spring.boot.test.app1.modules.system.entity.converter.SysRoleConverter;
import com.yuan.spring.boot.test.app1.modules.system.entity.domain.SysRole;
import com.yuan.spring.boot.test.app1.modules.system.entity.dto.SysRoleExcelEntity;
import com.yuan.spring.boot.test.app1.modules.system.entity.dto.SysRoleQueryParams;
import com.yuan.spring.boot.test.app1.modules.system.entity.dto.SysRoleQueryResult;
import com.yuan.spring.boot.test.app1.modules.system.entity.dto.SysUserExcelEntity;
import com.yuan.spring.boot.test.app1.modules.system.service.SysRoleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;
import java.util.StringJoiner;

/**
 * @author yuane
 * @date 2019/7/17 1:02
 **/
@Service
public class SysRoleServiceImpl extends AbstractCommonsServiceImpl<SysRoleDao, SysRole> implements SysRoleService {
    private final SysRoleConverter sysRoleConverter;

    public SysRoleServiceImpl(SysRoleConverter sysRoleConverter) {
        this.sysRoleConverter = sysRoleConverter;
    }

    @Override
    public ServiceResult checkSave(SysRole sysRole) throws CheckNotPassException {
        boolean passFlag = true;
        StringJoiner stringJoinerr = new StringJoiner("", ",", ".");
        String name = sysRole.getName();
        if (ObjectUtil.isEmpty(name)) {
            passFlag = false;
            stringJoinerr.add("名称不能为空");
        } else {
            if (baseDao.existsByName(name)) {
                passFlag = false;
                stringJoinerr.add(name + "已存在");
            }
        }
        return CheckMessageUtils.build(passFlag, stringJoinerr.toString());
    }

    @Override
    public ServiceResult checkUpdate(SysRole sysRole) throws CheckNotPassException {
        boolean passFlag = true;
        StringJoiner stringJoinerr = new StringJoiner("", ",", ".");
        String name = sysRole.getName();
        if (ObjectUtil.isEmpty(name)) {
            passFlag = false;
            stringJoinerr.add("名称不能为空");
        }
        return CheckMessageUtils.build(passFlag, stringJoinerr.toString());
    }

    @Override
    public ServiceResult checkDelete(SysRole sysRole) throws CheckNotPassException {
        return ServiceResultUtils.ok();
    }

    @Override
    public Page<SysRoleQueryResult> findAll(SysRoleQueryParams queryParams, Pageable pageable) {

        return baseDao.findPageByParams(queryParams, pageable);
    }

    @Override
    public List<SysRoleQueryResult> findAll(SysRoleQueryParams queryParams) {
        return baseDao.findListByParams(queryParams);
    }

    @Override
    public SysRoleQueryResult findOne(SysRoleQueryParams queryParams) {
        return baseDao.findOneByParams(queryParams);
    }

    @SuppressWarnings("unchecked")
    @Override
    public ServiceResult<ExcelImportResult<SysRoleExcelEntity>> upload(MultipartFile file) throws Exception {
        InputStream inputStream = file.getInputStream();
        ImportParams params = new ImportParams();
        params.setNeedVerify(true);
        params.setVerifyHandler((IExcelVerifyHandler<SysRoleExcelEntity>) this::verifyHandler);
        ExcelImportResult<SysRoleExcelEntity> result = ExcelImportUtil.importExcelMore(file.getInputStream(), SysUserExcelEntity.class, params);
        if (result.isVerfiyFail()) {
            return ServiceResultUtils.error("导入失败", result);
        } else {
            return saveOrUpdateBatch(sysRoleConverter.excelToDomain(result.getList()));
        }
    }

    private ExcelVerifyHandlerResult verifyHandler(SysRoleExcelEntity excelEntity) {
        boolean passFlag = true;
        StringJoiner stringJoiner = new StringJoiner(",");
        String name = excelEntity.getName();
        Integer enabled = excelEntity.getEnabled();
        if (ObjectUtil.isEmpty(name)) {
            passFlag = false;
            stringJoiner.add("名称不能为空");
        } else {
            if (baseDao.existsByName(name)) {
                passFlag = false;
                stringJoiner.add(name + "已存在");
            }
        }
        return new ExcelVerifyHandlerResult(passFlag, stringJoiner.toString());
    }
}
