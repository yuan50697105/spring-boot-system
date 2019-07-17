package com.yuan.spring.boot.dao.commons.utils;

import cn.hutool.core.util.ObjectUtil;
import com.yuan.spring.boot.dao.commons.entity.dto.ServiceResult;

/**
 * @author yuane
 * @date 2019/7/14 13:35
 **/
public class CheckMessageUtils {
    public static ServiceResult build(boolean pass, String message) {
        if (pass) {
            if (ObjectUtil.isEmpty(message)) {
                return ServiceResultUtils.ok();
            } else {
                return ServiceResultUtils.ok(message);
            }
        } else {
            return ServiceResultUtils.error(message);
        }
    }
}
