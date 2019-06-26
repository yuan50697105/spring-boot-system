package com.yuan.springbootwebmybatisplus.system.entity.bo;

import com.yuan.springbootwebmybatisplus.commons.entity.bo.BaseQueryParams;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author yuane
 * @date 2019/6/25 19:04
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class SysUserQueryParams extends BaseQueryParams {
    private String name;

    public SysUserQueryParams() {
    }


    public SysUserQueryParams(String name) {
        this.name = name;
    }

    @Builder
    public SysUserQueryParams(String id, String[] ids, Iterable<String> iterable, String createUser, String updateUser, Date createDate, Date updateDate, Date createDateStart, Date createDateEnd, Date updateDateStart, Date updateDateEnd, String name) {
        super(id, ids, iterable, createUser, updateUser, createDate, updateDate, createDateStart, createDateEnd, updateDateStart, updateDateEnd);
        this.name = name;
    }
}
