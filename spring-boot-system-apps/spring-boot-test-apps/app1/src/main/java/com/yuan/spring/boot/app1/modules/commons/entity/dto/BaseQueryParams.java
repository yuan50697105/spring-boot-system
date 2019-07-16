package com.yuan.spring.boot.app1.modules.commons.entity.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author yuane
 * @date 2019/7/13 1:15
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public abstract class BaseQueryParams extends com.yuan.spring.boot.dao.mybatis.plus.entity.dto.MybatisPlusQueryParams<Long> {
    private Long createBy;
    private Long updateBy;
    private Date createDateStart;
    private Date createDateEnd;
    private Date updateDateStart;
    private Date updateDateEnd;

    public BaseQueryParams() {
    }

    public BaseQueryParams(Long createBy, Long updateBy, Date createDateStart, Date createDateEnd, Date updateDateStart, Date updateDateEnd) {
        this.createBy = createBy;
        this.updateBy = updateBy;
        this.createDateStart = createDateStart;
        this.createDateEnd = createDateEnd;
        this.updateDateStart = updateDateStart;
        this.updateDateEnd = updateDateEnd;
    }

    public BaseQueryParams(Long id, Long[] ids, Long createBy, Long updateBy, Date createDateStart, Date createDateEnd, Date updateDateStart, Date updateDateEnd) {
        super(id, ids);
        this.createBy = createBy;
        this.updateBy = updateBy;
        this.createDateStart = createDateStart;
        this.createDateEnd = createDateEnd;
        this.updateDateStart = updateDateStart;
        this.updateDateEnd = updateDateEnd;
    }
}
