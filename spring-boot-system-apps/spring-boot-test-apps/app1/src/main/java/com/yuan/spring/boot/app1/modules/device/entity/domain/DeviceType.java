package com.yuan.spring.boot.app1.modules.device.entity.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.yuan.spring.boot.app1.modules.commons.entity.domain.BaseDomain;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author yuane
 * @date 2019/7/16 18:57
 **/
@EqualsAndHashCode(callSuper = true)
@TableName("device_type")
@Data
public class DeviceType extends BaseDomain {
    private String name;
    private String desc;

    public DeviceType() {
    }

    public DeviceType(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    @Builder
    public DeviceType(String id, String createBy, String updateBy, Date createDate, Date updateDate, String name, String desc) {
        super(id, createBy, updateBy, createDate, updateDate);
        this.name = name;
        this.desc = desc;
    }
}
