package com.yuan.spring.boot.app1.modules.system.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.map.MapUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuan.spring.boot.app1.modules.commons.controller.BaseController;
import com.yuan.spring.boot.app1.modules.system.entity.converter.SysUserConvertor;
import com.yuan.spring.boot.app1.modules.system.entity.domain.SysUser;
import com.yuan.spring.boot.app1.modules.system.entity.dto.SysUserQueryParams;
import com.yuan.spring.boot.app1.modules.system.entity.vo.SysUserVo;
import com.yuan.spring.boot.app1.modules.system.service.SysUserService;
import com.yuan.spring.boot.dao.commons.entity.vo.PageVo;
import com.yuan.spring.boot.dao.mybatis.plus.utils.PageUtils;
import com.yuan.spring.web.mvc.annotation.ViewPrefix;
import com.yuan.spring.web.mvc.entity.vo.AjaxResult;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author yuane
 * @date 2019/7/13 8:39
 **/
@Controller
@RequestMapping("system/user")
@ViewPrefix("system/user")
public class SysUserController extends BaseController {
    private final SysUserService sysUserService;
    private final SysUserConvertor sysUserConvertor;

    public SysUserController(SysUserService sysUserService, SysUserConvertor sysUserConvertor) {
        this.sysUserService = sysUserService;
        this.sysUserConvertor = sysUserConvertor;
    }

    @RequestMapping
    private String index() {
        return display("index");
    }

    @RequestMapping("dataGrid")
    @ResponseBody
    public AjaxResult dataGrid(SysUserQueryParams queryParams, int page, int size) {
        IPage<SysUser> iPage = sysUserService.selectPageByParams(new Page<>(page, size), queryParams);
        Page<SysUserVo> sysUserVoPage = sysUserConvertor.domainToVo(iPage);
        PageVo<SysUserVo> pageVo = PageUtils.build(sysUserVoPage);
        return AjaxResult.data(pageVo);
    }

    @RequestMapping("dataList")
    @ResponseBody
    public AjaxResult dataList(SysUserQueryParams queryParams) {
        return AjaxResult.data(sysUserService.selectListByParams(queryParams));
    }

    @RequestMapping("dataOne")
    @ResponseBody
    public AjaxResult dataOne(SysUserQueryParams queryParams) {
        return AjaxResult.data(sysUserService.selectOneByParams(queryParams));
    }

    @RequestMapping("add")
    public String add() {
        return display("save");
    }

    @RequestMapping("edit")
    public ModelAndView edit(String id) {
        Map<String, SysUser> data = MapUtil.builder("data", sysUserService.get(id)).build();
        return displayModelAndView("edit", data);
    }

    @RequestMapping("checkSaveOrUpdate")
    @ResponseBody
    public AjaxResult checkSaveOrUpdate(@RequestBody SysUserVo sysUserVo) {
        SysUser sysUser = sysUserConvertor.voToDomain(sysUserVo);
        return sysUserService.checkSaveOrUpdate(sysUser).convert();
    }

    @RequestMapping("saveOrUpdate")
    @ResponseBody
    public AjaxResult saveOrUpdate(SysUserVo sysUserVo) {
        SysUser sysUser = sysUserConvertor.voToDomain(sysUserVo);
        return sysUserService.saveOrUpdate(sysUser).convert();
    }

    @RequestMapping("save")
    @ResponseBody
    public AjaxResult save(SysUserVo sysUserVo) {
        SysUser sysUser = sysUserConvertor.voToDomain(sysUserVo);
        return sysUserService.save(sysUser).convert();
    }

    @RequestMapping("update")
    @ResponseBody
    public AjaxResult update(SysUserVo sysUserVo) {
        SysUser sysUser = sysUserConvertor.voToDomain(sysUserVo);
        return sysUserService.update(sysUser).convert();
    }

    @RequestMapping("delete")
    @ResponseBody
    public AjaxResult delete(String[] id) {
        return sysUserService.deleteById(id).convert();
    }

    @RequestMapping("upload")
    @ResponseBody
    public AjaxResult upload(MultipartFile file) {
        try (InputStream inputStream = file.getInputStream()) {
            try {
                List<SysUserVo> objects = ExcelImportUtil.importExcel(inputStream, SysUserVo.class, new ImportParams());
                List<SysUser> sysUsers = sysUserConvertor.voToDomain(objects);
                return sysUserService.saveBatch(sysUsers).convert();
            } catch (Exception e) {
                throw new Exception(e);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.error(e.getMessage());
        }
    }

    @RequestMapping("download")
    @ResponseBody
    public ResponseEntity<byte[]> download(SysUserQueryParams queryParams) {
        try {
            ExportParams exportParams = new ExportParams("用户列表" + DateUtil.formatDate(new Date()), "用户列表");
            List<SysUser> sysUsers = sysUserService.selectListByParams(queryParams);
            List<SysUserVo> sysUserVos = sysUserConvertor.domainToVo(sysUsers);
            Workbook workbook = ExcelExportUtil.exportExcel(exportParams, SysUserVo.class, sysUserVos);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            workbook.write(byteArrayOutputStream);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentDispositionFormData("attachment", "1workbook.xls");// new String("线上消费记录".getBytes("GBK"),"iso-8859-1")
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            return new ResponseEntity<>(byteArrayOutputStream.toByteArray(), headers, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

}
