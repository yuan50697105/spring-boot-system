package com.yuan.springbootwebmybatisplus.system.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.yuan.springbootwebmybatisplus.commons.entity.po.BasePo;

/**
 * @author yuane
 * @date 2019/6/20 23:00
 **/
@TableName("sys_user_role")
public class SysUserRole extends BasePo {
    private Long userId;
    private Long roleId;
}
