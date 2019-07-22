package com.yuan.spring.boot.app2.modules.system.service.impl;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import cn.afterturn.easypoi.excel.entity.result.ExcelVerifyHandlerResult;
import cn.afterturn.easypoi.handler.inter.IExcelVerifyHandler;
import cn.hutool.core.date.DateUtil;
import com.github.liaochong.myexcel.utils.AttachmentExportUtil;
import com.yuan.spring.boot.app2.modules.commons.service.impl.BaseServiceImpl;
import com.yuan.spring.boot.app2.modules.system.dao.SysUserDao;
import com.yuan.spring.boot.app2.modules.system.entity.converter.SysUserConverter;
import com.yuan.spring.boot.app2.modules.system.entity.domain.SysUser;
import com.yuan.spring.boot.app2.modules.system.entity.dto.SysUserExcelEntity;
import com.yuan.spring.boot.app2.modules.system.entity.dto.SysUserQueryParams;
import com.yuan.spring.boot.app2.modules.system.entity.dto.SysUserQueryResult;
import com.yuan.spring.boot.app2.modules.system.service.SysUseService;
import com.yuan.spring.boot.dao.commons.entity.dto.ServiceResult;
import com.yuan.spring.boot.dao.commons.utils.ServiceResultUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @author yuane
 * @date 2019/7/22 23:03
 **/
@Service
public class SysUseServiceImpl extends BaseServiceImpl<SysUserDao, SysUser> implements SysUseService {
    private final SysUserConverter sysUserConverter;

    public SysUseServiceImpl(SysUserConverter sysUserConverter) {
        this.sysUserConverter = sysUserConverter;
    }


    public ServiceResult checkSave(SysUser sysUser) {
        return ServiceResultUtils.ok();
    }

    public ServiceResult checkUpdate(SysUser sysUser) {
        return ServiceResultUtils.ok();
    }

    public ServiceResult checkDelete(SysUser sysUser) {
        return ServiceResultUtils.ok();
    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ServiceResult<ExcelImportResult<SysUserExcelEntity>> upload(InputStream stream) {
        try {
            ImportParams params = new ImportParams();
            params.setNeedVerify(true);
            params.setVerifyHandler((IExcelVerifyHandler<SysUserExcelEntity>) this::verifyHandler);
            ExcelImportResult<SysUserExcelEntity> result = ExcelImportUtil.importExcelMore(stream, SysUserExcelEntity.class, new ImportParams());
            if (result.isVerfiyFail()) {
                return ServiceResultUtils.error("", result);
            } else {
                return baseSaveOrUpdateBatch(sysUserConverter.excelToDomain(result.getList()));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void download(SysUserQueryParams queryParams, HttpServletResponse response) {
        List<SysUserQueryResult> queryResults = baseDao.selectQueryResultListByParams(queryParams);
        List<SysUserExcelEntity> sysUserExcelEntities = sysUserConverter.queryToExcel(queryResults);
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("用户列表", "用户列表"), SysUserExcelEntity.class, sysUserExcelEntities);
        AttachmentExportUtil.export(workbook, "用户列表" + DateUtil.formatDateTime(new Date()), response);
    }

    private ExcelVerifyHandlerResult verifyHandler(SysUserExcelEntity obj) {
        ServiceResult serviceResult = checkSaveOrUpdate(obj);
        return new ExcelVerifyHandlerResult(serviceResult.getStatus().equals(ServiceResult.Status.OK), serviceResult.getMessage());
    }
}
