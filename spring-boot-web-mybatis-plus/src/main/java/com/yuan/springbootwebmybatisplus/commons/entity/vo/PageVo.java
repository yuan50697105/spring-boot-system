package com.yuan.springbootwebmybatisplus.commons.entity.vo;

import lombok.Data;

import java.util.List;

/**
 * @author yuane
 * @date 2019/6/21 21:12
 **/
@Data
public final class PageVo {
    private Long total;
    private List list;

    private PageVo(Long total, List list) {
        this.total = total;
        this.list = list;
    }

    public static PageVo of(Long total, List list) {
        return new PageVo(total, list);
    }
}
