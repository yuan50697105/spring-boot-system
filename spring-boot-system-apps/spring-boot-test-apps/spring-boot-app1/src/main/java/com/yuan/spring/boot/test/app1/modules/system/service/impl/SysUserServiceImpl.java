package com.yuan.spring.boot.test.app1.modules.system.service.impl;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
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
import com.yuan.spring.boot.test.app1.modules.system.dao.SysUserDao;
import com.yuan.spring.boot.test.app1.modules.system.entity.converter.SysUserConverter;
import com.yuan.spring.boot.test.app1.modules.system.entity.domain.SysUser;
import com.yuan.spring.boot.test.app1.modules.system.entity.dto.SysUserExcelEntity;
import com.yuan.spring.boot.test.app1.modules.system.entity.dto.SysUserQueryParams;
import com.yuan.spring.boot.test.app1.modules.system.entity.dto.SysUserQueryResult;
import com.yuan.spring.boot.test.app1.modules.system.service.SysUserService;
import com.yuan.spring.boot.utils.SpellUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.StringJoiner;

/**
 * @author yuane
 * @date 2019/7/17 0:52
 **/
@Service
public class SysUserServiceImpl extends AbstractCommonsServiceImpl<SysUserDao, SysUser> implements SysUserService {
    @Autowired
    private SysUserConverter sysUserConverter;
    @Autowired
    private SysUserDao sysUserDao;

    @Override
    public ServiceResult checkSave(SysUser sysUser) throws CheckNotPassException {
        boolean passFlag = true;
        StringJoiner stringJoiner = new StringJoiner("", ",", ".");
//        username验证
        String username = sysUser.getUsername();
        if (ObjectUtil.isEmpty(username)) {
//验证为空
            passFlag = false;
            stringJoiner.add("账户不能为空");
        } else {
//            不为空
            if (baseDao.existsByUsername(username)) {
                passFlag = false;
                stringJoiner.add(username + "已存在");
            }
        }
        return CheckMessageUtils.build(passFlag, stringJoiner.toString());
    }

    @Override
    public ServiceResult checkUpdate(SysUser sysUser) throws CheckNotPassException {
        boolean passFlag = true;
        StringJoiner stringJoiner = new StringJoiner("", ",", ".");
//        username验证
        String username = sysUser.getUsername();
        if (ObjectUtil.isEmpty(username)) {
//验证为空
            passFlag = false;
            stringJoiner.add("账户不能为空");
        }
        return CheckMessageUtils.build(passFlag, stringJoiner.toString());
    }

    @Override
    public ServiceResult checkDelete(SysUser sysUser) throws CheckNotPassException {
        return CheckMessageUtils.build(true, "");
    }

    @SuppressWarnings("unchecked")
    @Override
    public ServiceResult<ExcelImportResult<SysUserExcelEntity>> upload(MultipartFile file) throws Exception {
        ImportParams params = new ImportParams();
        params.setNeedVerify(true);
        params.setImportFields(new String[]{"账户名", "用户名", "状态", "主键"});
        params.setVerifyHandler((IExcelVerifyHandler<SysUserExcelEntity>) this::verifyHandler);
        ExcelImportResult<SysUserExcelEntity> result = ExcelImportUtil.importExcelMore(file.getInputStream(), SysUserExcelEntity.class, params);
        if (result.isVerfiyFail()) {
            return ServiceResultUtils.error("错误导入", result);
        } else {
            List<SysUser> sysUsers = sysUserConverter.excelEntityToDomain(result.getList());
            return saveOrUpdateBatch(sysUsers);
        }
    }

    @Override
    public Workbook download(SysUserQueryParams queryParams) {
        ExportParams exportParams = new ExportParams();
        exportParams.setSheetName("用户列表");
        exportParams.setTitle("用户列表");
        exportParams.setExclusions(new String[]{"密码", "错误信息", "行号", "主键"});
        List<SysUserQueryResult> queryResults = baseDao.findListByParams(queryParams);
        List<SysUserExcelEntity> sysUserExcelEntities = sysUserConverter.queryResultToExcelEntity(queryResults);
        return ExcelExportUtil.exportExcel(exportParams, SysUserExcelEntity.class, sysUserExcelEntities);
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

    private ExcelVerifyHandlerResult verifyHandler(SysUserExcelEntity importEntity) {
        boolean passFlag = true;
        StringJoiner joiner = new StringJoiner(",");
        @NotNull(message = "账户名不能为空") String username = importEntity.getUsername();
        if (baseDao.existsByUsername(username)) {
            passFlag = false;
            joiner.add("用户名" + username + "已存在");
        }
        return new ExcelVerifyHandlerResult(passFlag, joiner.toString());
    }

    @Override
    public ServiceResult save(SysUser sysUser) {
        String name = sysUser.getName();
        if (ObjectUtil.isNotEmpty(name)) {
            sysUser.setNameSpellFull(SpellUtils.getSpell(name));
            sysUser.setNameSpellSimple(SpellUtils.getFirstSpell(name));
        }
        return super.save(sysUser);
    }

    @Override
    public ServiceResult update(SysUser sysUser) {
        String name = sysUser.getName();
        if (ObjectUtil.isNotEmpty(name)) {
            sysUser.setNameSpellSimple(SpellUtils.getFirstSpell(name));
            sysUser.setNameSpellFull(SpellUtils.getSpell(name));
        }
        return super.update(sysUser);
    }
}
