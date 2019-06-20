package com.yuan.springbootwebjpa.system.entity.po;

import com.yuan.springbootwebjpa.commons.entity.po.BasePo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author yuane
 * @date 2019/6/20 22:40
 **/
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "sys_resource")
@Data
public class SysResource extends BasePo {
    private String name;
    private String content;
    private String url;
    private Integer type;
    private String icon;
    private Long parent;

}
