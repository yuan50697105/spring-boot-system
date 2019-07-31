package com.yuan.spring.app1.modules.system.service.impl;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuan.spring.app1.modules.commons.controller.BaseController;
import com.yuan.spring.app1.modules.commons.service.impl.BaseServiceImpl;
import com.yuan.spring.app1.modules.commons.utils.PageVo;
import com.yuan.spring.app1.modules.system.dao.SysRoeDao;
import com.yuan.spring.app1.modules.system.entity.domain.SysRole;
import com.yuan.spring.app1.modules.system.entity.dto.SysRoleQueryParams;
import com.yuan.spring.app1.modules.system.service.SysRoleService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * @author yuane
 * @date 2019/7/30 22:36
 **/
@Service
public class SysRoleServiceImpl extends BaseServiceImpl<SysRoeDao, SysRole> implements SysRoleService {
    @Override
    public PageVo<Map<String, Object>> listData(SysRoleQueryParams queryParams, PageVo page) {
        Page page1 = new Page(page.getPage(), page.getSize());
        Page<Map<String, Object>> mapPage = baseMapper.selectPageByParams(page1, queryParams);
        page.setData(mapPage.getRecords());
        page.setTotal(mapPage.getTotal());
        return page;
    }

    @Override
    public BaseController.AjaxResult upload(MultipartFile file) {
        try {
            InputStream inputStream = file.getInputStream();
            ImportParams importParams = new ImportParams();
            ExcelImportResult<Object> objectExcelImportResult = ExcelImportUtil.importExcelMore(inputStream, SysRole.class, importParams);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
