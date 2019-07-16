package com.yuan.spring.boot.app1.modules.device.entity.vo;

import com.yuan.spring.boot.app1.modules.commons.entity.vo.BaseVo;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author yuane
 * @date 2019/7/16 18:59
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class DeviceTypeVo extends BaseVo {
    private String name;
    private String desc;

    public DeviceTypeVo() {
    }

    public DeviceTypeVo(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public DeviceTypeVo(String createBy, String updateBy, Date createDate, Date updateDate, String name, String desc) {
        super(createBy, updateBy, createDate, updateDate);
        this.name = name;
        this.desc = desc;
    }

    @Builder
    public DeviceTypeVo(String s, String createBy, String updateBy, Date createDate, Date updateDate, String name, String desc) {
        super(s, createBy, updateBy, createDate, updateDate);
        this.name = name;
        this.desc = desc;
    }
}
