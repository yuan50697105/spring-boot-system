package com.yuan.spring.boot.app2.modules.system.service;

import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import com.yuan.spring.boot.app2.modules.commons.service.BaseService;
import com.yuan.spring.boot.app2.modules.system.entity.domain.SysUser;
import com.yuan.spring.boot.app2.modules.system.entity.dto.SysUserExcelEntity;
import com.yuan.spring.boot.app2.modules.system.entity.dto.SysUserQueryParams;
import com.yuan.spring.boot.dao.commons.entity.dto.ServiceResult;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;

/**
 * @author yuane
 * @date 2019/7/22 23:03
 **/
public interface SysUseService extends BaseService<SysUser> {
    @SuppressWarnings("unchecked")
    ServiceResult<ExcelImportResult<SysUserExcelEntity>> upload(InputStream stream);

    void download(SysUserQueryParams queryParams, HttpServletResponse response);
}
