package com.yuan.spring.boot.dao.commons.utils;


import com.yuan.spring.boot.dao.commons.entity.vo.PageVo;

import java.util.List;

/**
 * @author yuane
 * @date 2019/7/13 12:33
 **/
public class PageUtils {
    public static <T> PageVo<T> build(Long total, List<T> data) {
        return new PageVo<T>(total, data);
    }
}
