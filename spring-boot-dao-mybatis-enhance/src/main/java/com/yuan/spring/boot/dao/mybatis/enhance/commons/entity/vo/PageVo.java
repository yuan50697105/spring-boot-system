package com.yuan.spring.boot.dao.mybatis.enhance.commons.entity.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class PageVo implements Serializable {
    private Long total;
    private List data;

    private PageVo(Long total, List data) {
        this.total = total;
        this.data = data;
    }

    public static PageVo of(Long total, List data) {
        return new PageVo(total, data);
    }
}
