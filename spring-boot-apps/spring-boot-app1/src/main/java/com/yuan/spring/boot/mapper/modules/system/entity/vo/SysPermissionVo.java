package com.yuan.spring.boot.mapper.modules.system.entity.vo;

import com.yuan.spring.boot.mapper.modules.commons.entity.vo.BaseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author yuane
 * @date 2019/7/14 23:24
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class SysPermissionVo extends BaseVo {
    public SysPermissionVo() {
    }

    public SysPermissionVo(String createBy, String updateBy, Date createDate, Date updateDate) {
        super(createBy, updateBy, createDate, updateDate);
    }

    public SysPermissionVo(String s, String createBy, String updateBy, Date createDate, Date updateDate) {
        super(s, createBy, updateBy, createDate, updateDate);
    }
}
