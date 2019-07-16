package com.yuan.spring.boot.app1.modules.system;

import com.yuan.spring.boot.app1.modules.commons.entity.domain.BaseDomain;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author yuane
 * @date 2019/7/16 21:06
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class SysUser extends BaseDomain {
    private String username;
    private String password;
    private String name;
    private Integer enabled;

    public SysUser() {

    }
    public SysUser(String username, String password, String name, Integer enabled) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.enabled = enabled;
    }

    @Builder
    public SysUser(Long id, Long createBy, Long updateBy, Date createDate, Date updateDate, String username, String password, String name, Integer enabled) {
        super(id, createBy, updateBy, createDate, updateDate);
        this.username = username;
        this.password = password;
        this.name = name;
        this.enabled = enabled;
    }
}
