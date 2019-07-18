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
import com.yuan.spring.boot.test.app1.modules.system.dao.SysRoleDao;
import com.yuan.spring.boot.test.app1.modules.system.entity.converter.SysRoleConverter;
import com.yuan.spring.boot.test.app1.modules.system.entity.domain.SysRole;
import com.yuan.spring.boot.test.app1.modules.system.entity.dto.SysRoleExcelEntity;
import com.yuan.spring.boot.test.app1.modules.system.entity.dto.SysRoleQueryParams;
import com.yuan.spring.boot.test.app1.modules.system.entity.dto.SysRoleQueryResult;
import com.yuan.spring.boot.test.app1.modules.system.service.SysRoleService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

@Service
public class SysRoleServiceImpl extends AbstractCommonsService<SysRoleDao, SysRole> implements SysRoleService {
    private final SysRoleConverter sysRoleConverter;

    public SysRoleServiceImpl(SysRoleConverter sysRoleConverter) {
        this.sysRoleConverter = sysRoleConverter;
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
        ExcelImportResult<SysRoleExcelEntity> result = ExcelImportUtil.importExcelMore(inputStream, SysRoleExcelEntity.class, params);
        if (result.isVerfiyFail()) {
            return ServiceResultUtils.error("导入失败", result);
        } else {
            List<SysRole> roles = sysRoleConverter.excelToDomain(result.getList());
            return baseSaveOrUpdateBatch(roles);
        }
    }

    @Override
    public Workbook download(SysRoleQueryParams queryParams) {
        List<SysRoleQueryResult> list = baseDao.findListByParams(queryParams);
        List<SysRoleExcelEntity> entities = sysRoleConverter.queryResultToExcelEntity(list);
        return ExcelExportUtil.exportExcel(new ExportParams("角色列表", "角色列表"), SysRoleExcelEntity.class, entities);
    }

    private ExcelVerifyHandlerResult verifyHandler(SysRoleExcelEntity excelEntity) {
        SysRole sysRole = sysRoleConverter.excelToDomain(excelEntity);
        ServiceResult serviceResult = checkSaveOrUpdate(sysRole);
        return new ExcelVerifyHandlerResult(serviceResult.getStatus().equals(ServiceResult.Status.OK), serviceResult.getMessage());
    }
}
