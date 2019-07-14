package com.yuan.spring.boot.mapper.modules.commons.entity.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author yuane
 * @date 2019/7/13 11:55
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public abstract class BaseVo extends com.yuan.spring.boot.dao.mybatis.plus.entity.vo.MybatisPlusVo<String> {
    private String createBy;
    private String updateBy;
    private Date createDate;
    private Date updateDate;

    public BaseVo() {
    }

    public BaseVo(String createBy, String updateBy, Date createDate, Date updateDate) {
        this.createBy = createBy;
        this.updateBy = updateBy;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public BaseVo(String s, String createBy, String updateBy, Date createDate, Date updateDate) {
        super(s);
        this.createBy = createBy;
        this.updateBy = updateBy;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }
}
