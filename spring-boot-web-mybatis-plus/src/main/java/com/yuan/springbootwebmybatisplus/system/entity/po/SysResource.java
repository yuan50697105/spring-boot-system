package com.yuan.springbootwebmybatisplus.system.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.yuan.springbootwebmybatisplus.commons.entity.po.BasePo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author yuane
 * @date 2019/6/20 22:59
 **/
@EqualsAndHashCode(callSuper = true)
@TableName("sys_resource")
@Data
public class SysResource extends BasePo {
    private String name;
    private String content;
    private String url;
    private Integer type;
    private String icon;
    private Long parent;
}
