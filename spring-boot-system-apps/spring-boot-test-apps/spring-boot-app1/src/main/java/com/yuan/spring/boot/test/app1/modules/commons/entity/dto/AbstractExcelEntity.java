package com.yuan.spring.boot.test.app1.modules.commons.entity.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.handler.inter.IExcelDataModel;
import cn.afterturn.easypoi.handler.inter.IExcelModel;
import com.yuan.spring.boot.test.app1.modules.commons.entity.domain.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public abstract class AbstractExcelEntity extends AbstractEntity implements IExcelDataModel, IExcelModel {
    @Excel(name = "行号")
    private int rowNum;
    @Excel(name = "错误信息", orderNum = "-1")
    private String errorMsg;

    public AbstractExcelEntity() {
    }

    public AbstractExcelEntity(int rowNum, String errorMsg) {
        this.rowNum = rowNum;
        this.errorMsg = errorMsg;
    }

    public AbstractExcelEntity(Long id, int rowNum, String errorMsg) {
        super(id);
        this.rowNum = rowNum;
        this.errorMsg = errorMsg;
    }

    @Override
    public int getRowNum() {
        return rowNum;
    }

    @Override
    public void setRowNum(int rowNum) {
        this.rowNum = rowNum;
    }

    @Override
    public String getErrorMsg() {
        return errorMsg;
    }

    @Override
    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
