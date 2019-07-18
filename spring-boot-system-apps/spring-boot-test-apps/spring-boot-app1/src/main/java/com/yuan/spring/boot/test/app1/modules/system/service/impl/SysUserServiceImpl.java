package com.yuan.spring.boot.test.app1.modules.system.service.impl;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import cn.afterturn.easypoi.excel.entity.result.ExcelVerifyHandlerResult;
import cn.afterturn.easypoi.handler.inter.IExcelVerifyHandler;
import com.yuan.spring.boot.dao.commons.entity.dto.ServiceResult;
import com.yuan.spring.boot.dao.commons.utils.ServiceResultUtils;
import com.yuan.spring.boot.test.app1.modules.commons.service.impl.AbstractCommonsService;
import com.yuan.spring.boot.test.app1.modules.system.dao.SysUserDao;
import com.yuan.spring.boot.test.app1.modules.system.entity.converter.SysUserConverter;
import com.yuan.spring.boot.test.app1.modules.system.entity.domain.SysUser;
import com.yuan.spring.boot.test.app1.modules.system.entity.dto.SysUserExcelEntity;
import com.yuan.spring.boot.test.app1.modules.system.entity.dto.SysUserQueryParams;
import com.yuan.spring.boot.test.app1.modules.system.entity.dto.SysUserQueryResult;
import com.yuan.spring.boot.test.app1.modules.system.service.SysUserService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class SysUserServiceImpl extends AbstractCommonsService<SysUserDao, SysUser> implements SysUserService {
    private final SysUserConverter sysUserConverter;

    public SysUserServiceImpl(SysUserConverter sysUserConverter) {
        this.sysUserConverter = sysUserConverter;
    }

    @SuppressWarnings("unchecked")
    @Override
    public ServiceResult<ExcelImportResult<SysUserExcelEntity>> upload(MultipartFile file) throws Exception {
        ImportParams params = new ImportParams();
        params.setVerifyHandler((IExcelVerifyHandler<SysUserExcelEntity>) this::verifyHandler);
        params.setNeedVerify(true);
        params.setImportFields(new String[]{"账户名", "用户名", "状态", "主键"});
        ExcelImportResult<SysUserExcelEntity> result = ExcelImportUtil.importExcelMore(file.getInputStream(), SysUserExcelEntity.class, params);
        if (result.isVerfiyFail()) {
            //存在错误返回错误
            return ServiceResultUtils.error("导入失败", result);
        } else {
            List<SysUserExcelEntity> list = result.getList();
            List<SysUser> sysUsers = sysUserConverter.excelEntityToDomain(list);
            return baseSaveOrUpdateBatch(sysUsers);
        }
    }

    @Override
    public Workbook download(SysUserQueryParams queryParams) {
        List<SysUserQueryResult> results = findAll(queryParams);
        List<SysUserExcelEntity> entities = sysUserConverter.queryResultToExcelEntity(results);
        return ExcelExportUtil.exportExcel(new ExportParams("用户列表", "用户列表"), SysUserExcelEntity.class, entities);
    }

    @Override
    public Page<SysUserQueryResult> findAll(SysUserQueryParams queryParams, Pageable pageable) {
        return baseDao.findPageByParams(queryParams, pageable);
    }

    @Override
    public List<SysUserQueryResult> findAll(SysUserQueryParams queryParams) {
        return baseDao.findListByParams(queryParams);
    }

    @Override
    public SysUserQueryResult findOne(SysUserQueryParams queryParams) {
        return baseDao.findOneByParams(queryParams);
    }

    private ExcelVerifyHandlerResult verifyHandler(SysUserExcelEntity sysUserExcelEntity) {
        SysUser sysUser = sysUserConverter.excelEntityToDomain(sysUserExcelEntity);
        ServiceResult serviceResult = checkSaveOrUpdate(sysUser);
        return new ExcelVerifyHandlerResult(serviceResult.getStatus().equals(ServiceResult.Status.OK), serviceResult.getMessage());
    }
}
