package com.yuan.springbootwebjpa.commons.entity.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author yuane
 * @date 2019/6/21 20:55
 **/
@Data
public final class PageVo<T> implements Serializable {
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
