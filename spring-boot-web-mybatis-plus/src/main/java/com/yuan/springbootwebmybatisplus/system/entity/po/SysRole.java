package com.yuan.springbootwebmybatisplus.system.entity.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yuan.springbootwebmybatisplus.commons.entity.po.BasePo;

/**
 * @author yuane
 * @date 2019/6/20 22:58
 **/
@TableName("sys_role")
public class SysRole extends BasePo {
    private String name;
}
