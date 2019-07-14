package com.yuan.spring.boot.dao.mybatis.plus.utils;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuan.spring.boot.dao.commons.entity.vo.PageVo;

/**
 * @author yuane
 * @date 2019/7/13 22:39
 **/
public class PageUtils extends com.yuan.spring.boot.dao.commons.utils.PageUtils {
    public static PageVo build(IPage page) {
        return PageVo.build(page.getTotal(), page.getRecords());
    }
}
