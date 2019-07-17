package com.yuan.spring.boot.test.app1.modules.system.entity.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.yuan.spring.boot.test.app1.modules.commons.entity.dto.AbstractExcelEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

@EqualsAndHashCode(callSuper = true)
@Data
public class SysUserExcelEntity extends AbstractExcelEntity {
    @Excel(name = "账户名", isImportField = "true")
    @NotNull(message = "账户名不能为空")
    private String username;
    @Excel(name = "用户名", isImportField = "true")
    @NotNull(message = "用户名不能为空")
    private String name;
    @Excel(name = "状态", replace = {"启用_0", "停用_1"}, isImportField = "true")
    private Integer enabled;


    public SysUserExcelEntity() {
    }

    public SysUserExcelEntity(@NotNull(message = "账户名不能为空") String username, @NotNull(message = "用户名不能为空") String name, Integer enabled) {
        this.username = username;
        this.name = name;
        this.enabled = enabled;
    }

    public SysUserExcelEntity(Long id, int rowNum, String errorMsg, @NotNull(message = "账户名不能为空") String username, @NotNull(message = "用户名不能为空") String name, Integer enabled) {
        super(id, rowNum, errorMsg);
        this.username = username;
        this.name = name;
        this.enabled = enabled;
    }
}
