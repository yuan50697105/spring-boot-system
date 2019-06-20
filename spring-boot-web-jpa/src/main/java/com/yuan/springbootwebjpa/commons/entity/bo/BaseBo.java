package com.yuan.springbootwebjpa.commons.entity.bo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yuane
 * @date 2019/6/20 19:23
 **/
@Data
public class BaseBo<T> implements Serializable {
    private T id;
    private T[] ids;
    private Iterable<T> iterable;
}
