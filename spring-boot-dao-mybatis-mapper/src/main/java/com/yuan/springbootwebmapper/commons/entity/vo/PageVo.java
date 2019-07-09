package com.yuan.springbootwebmapper.commons.entity.vo;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author yuane
 * @date 2019/6/21 20:55
 **/
@Data
public final class PageVo implements Serializable {
    private Long total;
    private List list;

    @Builder
    public PageVo(Long total, List list) {
        this.total = total;
        this.list = list;
    }

    public static PageVo of(Long total, List list) {
        return new PageVo(total, list);
    }
}
