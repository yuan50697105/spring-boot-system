package com.yuan.springbootwebjpa.system.entity.po;

import com.yuan.springbootwebjpa.commons.entity.po.BasePo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author yuane
 * @date 2019/6/20 22:39
 **/
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "sys_user_role")
@Data
public class SysUserRole extends BasePo {
    private Long userId;
    private Long roleId;
}
