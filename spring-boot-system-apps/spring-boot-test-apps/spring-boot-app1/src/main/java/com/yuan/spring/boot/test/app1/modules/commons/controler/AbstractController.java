package com.yuan.spring.boot.test.app1.modules.commons.controler;

import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import com.yuan.spring.boot.dao.commons.entity.dto.ServiceResult;
import com.yuan.spring.boot.test.app1.modules.commons.entity.dto.AbstractExcelEntity;
import com.yuan.spring.web.mvc.controller.BaseController;
import com.yuan.spring.web.mvc.entity.vo.AjaxResult;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author yuane
 * @date 2019/7/17 0:46
 **/

public abstract class AbstractController extends BaseController {
    protected ResponseEntity<byte[]> downloadExcelProcess(Workbook workbook) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        workbook.write(outputStream);
        return new ResponseEntity<>(outputStream.toByteArray(), HttpStatus.OK);
    }

    protected <T extends AbstractExcelEntity> ResponseEntity<byte[]> uploadExcelProcess(ServiceResult<ExcelImportResult<T>> serviceResult) throws IOException {
        if ("ok".equals(serviceResult.getCode())) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            Workbook failWorkbook = serviceResult.getData().getFailWorkbook();
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            failWorkbook.write(outputStream);
            return new ResponseEntity<>(outputStream.toByteArray(), HttpStatus.OK);
        }
    }

    @SuppressWarnings("ConstantConditions")
    protected AjaxResult checkFormProcess(Object t, BindingResult result, ServiceResult<?> serviceResult) {
        if (result.hasGlobalErrors()) {
            return AjaxResult.error(result.getGlobalError().getDefaultMessage());
        } else {
            return AjaxResult.ok();
        }
    }
}
