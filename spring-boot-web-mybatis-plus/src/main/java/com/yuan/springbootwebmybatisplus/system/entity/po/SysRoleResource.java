package com.yuan.springbootwebmybatisplus.system.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.yuan.springbootwebmybatisplus.commons.entity.po.BasePo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author yuane
 * @date 2019/6/20 23:01
 **/
@EqualsAndHashCode(callSuper = true)
@TableName("sys_role_resource")
@Data
public class SysRoleResource extends BasePo {
    private Long roleId;
    private Long resourceId;
}
