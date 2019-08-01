package com.yuan.spring.app1.modules.system.entity.dto;

import com.yuan.spring.app1.modules.system.entity.domain.SysResource;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author yuane
 * @date 2019/8/1 18:58
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class SysResourceQueryParams extends SysResource {
    public SysResourceQueryParams() {
    }

    @Builder
    public SysResourceQueryParams(String id, String[] ids, String createBy, String updateBy, Date createDate, Date updateDate, Date createDateStart, Date createDateEnd, Date updateDateStart, Date updateDateEnd, String name, String content, String url, String icon, String parent) {
        super(id, ids, createBy, updateBy, createDate, updateDate, createDateStart, createDateEnd, updateDateStart, updateDateEnd, name, content, url, icon, parent);
    }
}
