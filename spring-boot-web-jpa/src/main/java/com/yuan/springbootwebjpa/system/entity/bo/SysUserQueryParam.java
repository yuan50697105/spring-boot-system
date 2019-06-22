package com.yuan.springbootwebjpa.system.entity.bo;

import com.yuan.springbootwebjpa.commons.entity.bo.BaseQueryParam;
import com.yuan.springbootwebjpa.commons.entity.dto.MapQuery;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
    public SysUserQueryParam(String id, String[] ids, String createUser, String updateUser, Date createDate, Date createDateStart, Date createDateEnd, Date updateDate, Date updateDateStart, Date updateDateEnd, String name) {
        super(id, ids, createUser, updateUser, createDate, createDateStart, createDateEnd, updateDate, updateDateStart, updateDateEnd);
        this.name = name;
    }

    public MapQuery createBaseQuery() {
        StringBuilder stringBuilder = new StringBuilder();
        Map<String, Object> map = new HashMap<>();
        if (isNotEmpty(getId())) {

        }
        if (isNotEmpty(getIds())) {

        }
        if (isNotEmpty(getName())) {

        }
        return MapQuery.of(stringBuilder.toString(), map);
    }

}
