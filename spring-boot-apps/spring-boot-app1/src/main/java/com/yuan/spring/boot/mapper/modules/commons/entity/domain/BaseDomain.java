package com.yuan.spring.boot.mapper.modules.commons.entity.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.yuan.spring.boot.dao.mybatis.plus.entity.domain.MybatisPlusDomain;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author yuane
 * @date 2019/7/13 1:12
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public abstract class BaseDomain extends MybatisPlusDomain<String> {
    @TableId(type = IdType.UUID)
    private String id;
    private String createBy;
    private String updateBy;
    private Date createDate;
    private Date updateDate;

    public BaseDomain() {
    }

    public BaseDomain(String id, String createBy, String updateBy, Date createDate, Date updateDate) {
        this.id = id;
        this.createBy = createBy;
        this.updateBy = updateBy;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }
}
