package com.yuan.spring.boot.test.app1.modules.system.service;

import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import com.yuan.spring.boot.dao.commons.entity.dto.ServiceResult;
import com.yuan.spring.boot.test.app1.modules.commons.service.CommonsService;
import com.yuan.spring.boot.test.app1.modules.system.entity.domain.SysRole;
import com.yuan.spring.boot.test.app1.modules.system.entity.dto.SysRoleExcelEntity;
import com.yuan.spring.boot.test.app1.modules.system.entity.dto.SysRoleQueryParams;
import com.yuan.spring.boot.test.app1.modules.system.entity.dto.SysRoleQueryResult;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author yuane
 * @date 2019/7/17 1:01
 **/

public interface SysRoleService extends CommonsService<SysRole> {
    Page<SysRoleQueryResult> findAll(SysRoleQueryParams queryParams, Pageable pageable);

    List<SysRoleQueryResult> findAll(SysRoleQueryParams queryParams);

    SysRoleQueryResult findOne(SysRoleQueryParams queryParams);

    ServiceResult<ExcelImportResult<SysRoleExcelEntity>> upload(MultipartFile file) throws Exception;

    Workbook download(SysRoleQueryParams queryParams);
}
