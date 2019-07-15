package com.yuan.spring.boot.dao.commons.entity.vo;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author yuane
 * @date 2019/6/21 20:55
 **/
@Data
public class PageVo<T> implements Serializable {
    private Long total;
    private List<T> data;

    @Builder
    public PageVo(Long total, List<T> data) {
        this.total = total;
        this.data = data;
    }

    public static <T> PageVo build(Long total, List<T> data) {
        return new PageVo<T>(total, data);
    }

}
