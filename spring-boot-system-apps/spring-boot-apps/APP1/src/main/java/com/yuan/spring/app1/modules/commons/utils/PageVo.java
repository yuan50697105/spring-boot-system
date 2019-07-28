package com.yuan.spring.app1.modules.commons.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author yuane
 * @date 2019/7/27 13:55
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public final class PageVo<T> {
    private long total;
    private List<T> data;
    private int page;
    private int size;

}
