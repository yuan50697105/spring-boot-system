package com.yuan.spring.boot.dao.jdbc.utils;

import com.xphsc.easyjdbc.page.PageInfo;
import com.yuan.spring.boot.dao.commons.entity.vo.PageVo;

public class PageUtils extends com.yuan.spring.boot.dao.commons.utils.PageUtils {
    public static <T> PageVo<T> build(PageInfo<T> pageInfo) {
        return build(pageInfo.getTotal(), pageInfo.getList());
    }
}
