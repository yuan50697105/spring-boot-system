package com.yuan.springbootwebjpa.commons.entity.bo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yuane
 * @date 2019/6/20 19:23
 **/
@Data
public class BaseBo<T> implements Serializable {
    private T id;
    private T[] ids;
    private Iterable<T> iterable;
    private String createUser;
    private String updateUser;
    private Date createDate;
    private Date createDateStart;
    private Date createDateEnd;
    private Date updateDate;
    private Date updateDateStart;
    private Date updateDateEnd;
}
