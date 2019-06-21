package com.yuan.springbootwebenhance.commons.entity.vo;

import lombok.Data;

import java.util.List;

/**
 * @author yuane
 * @date 2019/6/21 20:51
 **/
@Data
public final class PageVo<T> {
    private Long total;
    private List<T> list;

    private PageVo(Long total, List<T> list) {
        this.total = total;
        this.list = list;
    }

    public static <T> PageVo<T> of(Long total, List<T> list) {
        return new PageVo<>(total, list);
    }
}
