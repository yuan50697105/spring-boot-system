package com.yuan.spring.boot.test.app1.modules.system.entity.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.yuan.spring.boot.test.app1.modules.commons.entity.dto.AbstractExcelEntity;
import com.yuan.spring.boot.test.app1.modules.commons.validator.SaveValidator;
import com.yuan.spring.boot.test.app1.modules.commons.validator.UpdateValidator;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

/**
 * @author yuane
 * @date 2019/7/17 19:04
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class SysPermissionExcelEntity extends AbstractExcelEntity {
    @Excel(name = "名城", isImportField = "true")
    @NotNull(message = "名称不能为空", groups = {SaveValidator.class, UpdateValidator.class})
    private String name;
    @Excel(name = "状态", replace = {"启用_0", "停用_1"}, isImportField = "true", isColumnHidden = true)
    private Integer enabled;

    public SysPermissionExcelEntity() {
    }

    public SysPermissionExcelEntity(String name, Integer enabled) {
        this.name = name;
        this.enabled = enabled;
    }

    public SysPermissionExcelEntity(int rowNum, String errorMsg, String name, Integer enabled) {
        super(rowNum, errorMsg);
        this.name = name;
        this.enabled = enabled;
    }

    public SysPermissionExcelEntity(Long id, int rowNum, String errorMsg, String name, Integer enabled) {
        super(id, rowNum, errorMsg);
        this.name = name;
        this.enabled = enabled;
    }

}
