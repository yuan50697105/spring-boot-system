package com.yuan.springbootwebmybatisplus.commons.entity.bo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yuane
 * @date 2019/6/20 22:56
 **/
@Data
public class BaseBo implements Serializable {
    private Long id;
    private Long[] ids;
    private Iterable<Long> iterable;
    private String createUser;
    private String updateUser;
    private Date createDate;
    private Date udpateDate;
    private Date createDateStart;
    private Date createDateEnd;
    private Date updateDateStart;
    private Date updateDateEnd;
}
