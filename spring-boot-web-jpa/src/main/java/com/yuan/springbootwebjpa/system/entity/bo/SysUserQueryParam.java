package com.yuan.springbootwebjpa.system.entity.bo;

import com.yuan.springbootwebjpa.commons.entity.bo.BaseQueryParam;
import com.yuan.springbootwebjpa.commons.entity.dto.ArrayQuery;
import com.yuan.springbootwebjpa.commons.entity.dto.CollectionQuery;
import com.yuan.springbootwebjpa.commons.entity.dto.MapQuery;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author yuane
 * @date 2019/6/20 19:22
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class SysUserQueryParam extends BaseQueryParam {
    private String name;

    public SysUserQueryParam() {
    }

    public SysUserQueryParam(String name) {
        this.name = name;
    }

    @Builder
    public SysUserQueryParam(String id, String[] ids, Iterable<String> iterable, String createUser, String updateUser, Date createDate, Date createDateStart, Date createDateEnd, Date updateDate, Date updateDateStart, Date updateDateEnd, String name) {
        super(id, ids, iterable, createUser, updateUser, createDate, createDateStart, createDateEnd, updateDate, updateDateStart, updateDateEnd);
        this.name = name;
    }

    @Override
    public MapQuery createMapQuery() {
        return null;
    }

    @Override
    public ArrayQuery createArrayQuery() {
        return null;
    }

    @Override
    public CollectionQuery createCollectQuery() {
        return null;
    }
}
