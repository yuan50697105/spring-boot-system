package com.yuan.spring.boot.test.app1.module.commons.entity.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.handler.inter.IExcelDataModel;
import cn.afterturn.easypoi.handler.inter.IExcelModel;
import lombok.Data;

/**
 * @author yuane
 * @date 2019/7/21 23:37
 **/
@Data
public class BaseExcelErrorResult implements IExcelModel, IExcelDataModel {
    @Excel(name = "行号")
    private int rowNum;
    @Excel(name = "错误信息")
    private String errorMsg;
}
