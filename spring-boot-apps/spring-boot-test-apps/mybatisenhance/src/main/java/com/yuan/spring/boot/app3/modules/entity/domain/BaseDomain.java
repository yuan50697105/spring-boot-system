package com.yuan.spring.boot.app3.modules.entity.domain;

import com.yuan.spring.boot.dao.mybatis.enhance.entity.domain.EnhanceDomain;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author yuane
 * @date 2019/7/16 0:50
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public abstract class BaseDomain extends EnhanceDomain<String> {
    private String id;
    private String createBy;
    private String updateBy;
    private Date createDate;
    private Date updateDate;

    public BaseDomain(String id, String createBy, String updateBy, Date createDate, Date updateDate) {
        this.id = id;
        this.createBy = createBy;
        this.updateBy = updateBy;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public BaseDomain(String s, String id, String createBy, String updateBy, Date createDate, Date updateDate) {
        super(s);
        this.id = id;
        this.createBy = createBy;
        this.updateBy = updateBy;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }
}
