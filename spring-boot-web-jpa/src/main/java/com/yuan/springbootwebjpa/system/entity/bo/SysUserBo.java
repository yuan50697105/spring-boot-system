package com.yuan.springbootwebjpa.system.entity.bo;

import com.yuan.springbootwebjpa.commons.entity.bo.BaseBo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author yuane
 * @date 2019/6/20 19:22
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class SysUserBo extends BaseBo {
    private String name;
}
