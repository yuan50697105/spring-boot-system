package com.yuan.spring.boot.dao.commons.utils;


import com.yuan.spring.boot.dao.commons.entity.vo.PageVo;

import java.util.List;

/**
 * @author yuane
 * @date 2019/7/13 12:33
 **/
public abstract class PageUtils {
    public static PageVo build(Long total, List data) {
        return new PageVo(total, data);
    }
}
