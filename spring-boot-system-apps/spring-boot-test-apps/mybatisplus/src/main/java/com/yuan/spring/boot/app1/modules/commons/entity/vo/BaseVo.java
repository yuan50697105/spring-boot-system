package com.yuan.spring.boot.app1.modules.commons.entity.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author yuane
 * @date 2019/7/13 11:55
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public abstract class BaseVo extends com.yuan.spring.boot.dao.mybatis.plus.entity.vo.MybatisPlusVo<String> {
    @ExcelIgnore
    private String createBy;
    @ExcelIgnore
    private String updateBy;
    @Excel(name = "创建时间", format = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;
    @ExcelIgnore
    private Date updateDate;

    public BaseVo() {
    }

    public BaseVo(String createBy, String updateBy, Date createDate, Date updateDate) {
        this.createBy = createBy;
        this.updateBy = updateBy;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public BaseVo(String s, String createBy, String updateBy, Date createDate, Date updateDate) {
        super(s);
        this.createBy = createBy;
        this.updateBy = updateBy;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }
}
