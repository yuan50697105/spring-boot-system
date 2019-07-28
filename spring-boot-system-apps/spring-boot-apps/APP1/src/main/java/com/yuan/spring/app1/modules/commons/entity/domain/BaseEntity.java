package com.yuan.spring.app1.modules.commons.entity.domain;

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
    @TableId(type = IdType.UUID)
    private String id;
    @TableField(value = "create_by", fill = FieldFill.INSERT)
    private String createBy;
    @TableField(value = "update_by", fill = FieldFill.UPDATE)
    private String updateBy;
    @TableField(value = "create_date", fill = FieldFill.INSERT)
    private Date createDate;
    @TableField(value = "update_date", fill = FieldFill.UPDATE)
    private Date updateDate;

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
}