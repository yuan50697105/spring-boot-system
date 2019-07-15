package com.yuan.spring.boot.app.modules.system.entity.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelIgnore;
import com.yuan.spring.boot.app.modules.commons.entity.vo.BaseVo;
import com.yuan.spring.boot.app.modules.commons.validator.SaveValidator;
import com.yuan.spring.boot.app.modules.commons.validator.UpdateValidator;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author yuane
 * @date 2019/7/13 1:25
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class SysUserVo extends BaseVo {

    @Excel(name = "用户名", isImportField = "true")
    @NotNull(groups = SaveValidator.class)
    private String username;
    @ExcelIgnore
    @NotNull(groups = {SaveValidator.class, UpdateValidator.class})
    private String password;
    @Excel(name = "姓名", isImportField = "true")
    @NotNull(groups = {SaveValidator.class, UpdateValidator.class})
    private String name;
    @Excel(name = "状态", replace = {"启用_0", "停用_1"}, isImportField = "true")
    private Integer enabled;

    public SysUserVo() {
    }

    public SysUserVo(String username, String password, String name, Integer enabled) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.enabled = enabled;
    }

    public SysUserVo(String createBy, String updateBy, Date createDate, Date updateDate, String username, String password, String name, Integer enabled) {
        super(createBy, updateBy, createDate, updateDate);
        this.username = username;
        this.password = password;
        this.name = name;
        this.enabled = enabled;
    }

    @Builder
    public SysUserVo(String id, String createBy, String updateBy, Date createDate, Date updateDate, String username, String password, String name, Integer enabled) {
        super(id, createBy, updateBy, createDate, updateDate);
        this.username = username;
        this.password = password;
        this.name = name;
        this.enabled = enabled;
    }
}
