package com.yuan.spring.boot.app1.modules.system.entity.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.yuan.spring.boot.app1.modules.commons.entity.vo.BaseVo;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author yuane
 * @date 2019/7/15 23:36
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class SysResourceVo extends BaseVo {
    @Excel(name = "资源名称", isImportField = "true")
    private String name;
    @Excel(name = "链接", isHyperlink = true, isImportField = "true")
    private String url;
    @Excel(name = "图标", isImportField = "true")
    private String icon;
    @Excel(name = "权限", isImportField = "true")
    private String permission;
    @Excel(name = "类型", replace = {"目录_0", "菜单_1", "按钮_2"})
    private Integer type;

    public SysResourceVo() {
    }

    public SysResourceVo(String name, String url, String icon, String permission, Integer type) {
        this.name = name;
        this.url = url;
        this.icon = icon;
        this.permission = permission;
        this.type = type;
    }

    public SysResourceVo(String createBy, String updateBy, Date createDate, Date updateDate, String name, String url, String icon, String permission, Integer type) {
        super(createBy, updateBy, createDate, updateDate);
        this.name = name;
        this.url = url;
        this.icon = icon;
        this.permission = permission;
        this.type = type;
    }

    @Builder
    public SysResourceVo(String id, String createBy, String updateBy, Date createDate, Date updateDate, String name, String url, String icon, String permission, Integer type) {
        super(id, createBy, updateBy, createDate, updateDate);
        this.name = name;
        this.url = url;
        this.icon = icon;
        this.permission = permission;
        this.type = type;
    }
}
