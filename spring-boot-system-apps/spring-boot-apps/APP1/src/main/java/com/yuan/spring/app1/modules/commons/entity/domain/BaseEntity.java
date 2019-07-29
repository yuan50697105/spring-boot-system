package com.yuan.spring.app1.modules.commons.entity.domain;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * @author yuane
 * @date 2019/7/27 10:45
 **/
@Data
public class BaseEntity {
    @TableId(value = "id", type = IdType.UUID)
    private String id;
    @TableField(value = "create_by", fill = FieldFill.INSERT)
    private String createBy;
    @TableField(value = "update_by", fill = FieldFill.UPDATE)
    private String updateBy;
    @TableField(value = "create_date", fill = FieldFill.INSERT)
    private Date createDate;
    @TableField(value = "update_date", fill = FieldFill.UPDATE)
    private Date updateDate;
    //日期查询字段
    @TableField(exist = false)
    private Date createDateStart;
    @TableField(exist = false)
    private Date createDateEnd;
    @TableField(exist = false)
    private Date updateDateStart;
    @TableField(exist = false)
    private Date updateDateEnd;
    @TableField(exist = false)
    private String[] ids;

    public BaseEntity() {
    }

    public BaseEntity(String id) {
        this.id = id;
    }

    public BaseEntity(String id, String createBy, String updateBy, Date createDate, Date updateDate) {
        this.id = id;
        this.createBy = createBy;
        this.updateBy = updateBy;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public BaseEntity(String id, String[] ids, String createBy, String updateBy, Date createDate, Date updateDate, Date createDateStart, Date createDateEnd, Date updateDateStart, Date updateDateEnd) {
        this.id = id;
        if (ObjectUtil.isEmpty(ids)) {
            this.ids = id.split(",");
        } else {
            this.ids = ids;
        }
        this.createBy = createBy;
        this.updateBy = updateBy;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.createDateStart = createDateStart;
        this.createDateEnd = createDateEnd;
        this.updateDateStart = updateDateStart;
        this.updateDateEnd = updateDateEnd;
    }
}
