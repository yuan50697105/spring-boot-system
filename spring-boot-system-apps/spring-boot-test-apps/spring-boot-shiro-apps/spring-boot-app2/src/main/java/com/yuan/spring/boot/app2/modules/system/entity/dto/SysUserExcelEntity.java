package com.yuan.spring.boot.app2.modules.system.entity.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.handler.inter.IExcelDataModel;
import cn.afterturn.easypoi.handler.inter.IExcelModel;
import com.yuan.spring.boot.app2.modules.system.entity.domain.SysUser;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author yuane
 * @date 2019/7/22 23:05
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class SysUserExcelEntity extends SysUser implements IExcelModel, IExcelDataModel {
    @Excel(name = "行号")
    private int rowNum;
    @Excel(name = "错误信息",orderNum = "-1")
    private String errorMsg;
}
