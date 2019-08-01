package com.yuan.spring.app1.modules.system.entity.vo;

import com.yuan.spring.app1.modules.system.entity.domain.SysResource;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author yuane
 * @date 2019/8/1 19:00
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class SysResourceVo extends SysResource {
    public SysResourceVo() {
    }

    @Builder
    public SysResourceVo(String name, String content, String url, String icon, String parent) {
        super(name, content, url, icon, parent);
    }
}
