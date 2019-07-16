package com.yuan.spring.boot.app1.modules.system.entity.dto;

import com.yuan.spring.boot.app1.modules.commons.entity.dto.BaseQueryParams;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author yuane
 * @date 2019/7/15 23:40
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class SysResourceQueryParams extends BaseQueryParams {
    private String name;
    private Integer type;

    public SysResourceQueryParams() {
    }

    public SysResourceQueryParams(String name, Integer type) {
        this.name = name;
        this.type = type;
    }

    public SysResourceQueryParams(String createBy, String updateBy, Date createDateStart, Date createDateEnd, Date updateDateStart, Date updateDateEnd, String name, Integer type) {
        super(createBy, updateBy, createDateStart, createDateEnd, updateDateStart, updateDateEnd);
        this.name = name;
        this.type = type;
    }

    @Builder
    public SysResourceQueryParams(String id, String[] ids, String createBy, String updateBy, Date createDateStart, Date createDateEnd, Date updateDateStart, Date updateDateEnd, String name, Integer type) {
        super(id, ids, createBy, updateBy, createDateStart, createDateEnd, updateDateStart, updateDateEnd);
        this.name = name;
        this.type = type;
    }
}
