package com.yuan.spring.boot.app.modules.system.entity.vo;

import com.yuan.spring.boot.app.modules.commons.entity.vo.BaseVo;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author yuane
 * @date 2019/7/13 1:25
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class SysUserVo extends BaseVo {
    private String username;
    private String password;
    private String name;
    private Integer enabled;

    public SysUserVo() {
    }

    public SysUserVo(String username, String password, String name, Integer enabled) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.enabled = enabled;
    }

    public SysUserVo(String createBy, String updateBy, Date createDate, Date updateDate, String username, String password, String name, Integer enabled) {
        super(createBy, updateBy, createDate, updateDate);
        this.username = username;
        this.password = password;
        this.name = name;
        this.enabled = enabled;
    }

    @Builder
    public SysUserVo(String id, String createBy, String updateBy, Date createDate, Date updateDate, String username, String password, String name, Integer enabled) {
        super(id, createBy, updateBy, createDate, updateDate);
        this.username = username;
        this.password = password;
        this.name = name;
        this.enabled = enabled;
    }
}
