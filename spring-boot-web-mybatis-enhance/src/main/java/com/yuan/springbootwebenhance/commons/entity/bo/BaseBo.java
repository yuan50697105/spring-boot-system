package com.yuan.springbootwebenhance.commons.entity.bo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yuane
 * @date 2019/6/21 20:39
 **/
@Data
public abstract class BaseBo implements Serializable {
    private String id;
    private String[] ids;
    private Iterable<String> iterable;
    private String createUser;
    private String updateUser;
    private Date createDate;
    private Date createDateStart;
    private Date createDateEnd;
    private Date updateDate;
    private Date updateDateStart;
    private Date updateDateEnd;

    public BaseBo() {
    }


    public BaseBo(String id, String[] ids, Iterable<String> iterable, String createUser, String updateUser, Date createDate, Date createDateStart, Date createDateEnd, Date updateDate, Date updateDateStart, Date updateDateEnd) {
        this.id = id;
        this.ids = ids;
        this.iterable = iterable;
        this.createUser = createUser;
        this.updateUser = updateUser;
        this.createDate = createDate;
        this.createDateStart = createDateStart;
        this.createDateEnd = createDateEnd;
        this.updateDate = updateDate;
        this.updateDateStart = updateDateStart;
        this.updateDateEnd = updateDateEnd;
    }
}
