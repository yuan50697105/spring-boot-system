package com.yuan.springbootwebjpa.system.entity.po;

import com.yuan.springbootwebjpa.commons.entity.po.BasePo;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

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

    public SysResource() {
    }

    public SysResource(String name, String content, String url, Integer type, String icon, Long parent) {
        this.name = name;
        this.content = content;
        this.url = url;
        this.type = type;
        this.icon = icon;
        this.parent = parent;
    }

    @Builder
    public SysResource(String id, Date createDate, Date updateDate, String createUser, String updateUser, String name, String content, String url, Integer type, String icon, Long parent) {
        super(id, createDate, updateDate, createUser, updateUser);
        this.name = name;
        this.content = content;
        this.url = url;
        this.type = type;
        this.icon = icon;
        this.parent = parent;
    }
}
