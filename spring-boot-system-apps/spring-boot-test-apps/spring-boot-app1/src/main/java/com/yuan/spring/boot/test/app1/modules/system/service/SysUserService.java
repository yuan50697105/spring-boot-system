package com.yuan.spring.boot.test.app1.modules.system.service;

import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import com.yuan.spring.boot.dao.commons.entity.dto.ServiceResult;
import com.yuan.spring.boot.test.app1.modules.commons.service.CommonsService;
import com.yuan.spring.boot.test.app1.modules.system.entity.domain.SysUser;
import com.yuan.spring.boot.test.app1.modules.system.entity.dto.SysUserExcelEntity;
import com.yuan.spring.boot.test.app1.modules.system.entity.dto.SysUserQueryParams;
import com.yuan.spring.boot.test.app1.modules.system.entity.dto.SysUserQueryResult;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author yuane
 * @date 2019/7/17 0:52
 **/
public interface SysUserService extends CommonsService<SysUser> {
    ServiceResult<ExcelImportResult<SysUserExcelEntity>> upload(MultipartFile file) throws Exception;

    Workbook download(SysUserQueryParams queryParams);

    Page<SysUserQueryResult> findAll(SysUserQueryParams queryParams, Pageable pageable);

    List<SysUserQueryResult> findAll(SysUserQueryParams queryParams);

    SysUserQueryResult findOne(SysUserQueryParams queryParams);
}
