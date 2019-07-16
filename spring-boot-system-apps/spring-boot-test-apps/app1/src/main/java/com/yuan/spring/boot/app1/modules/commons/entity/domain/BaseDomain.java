package com.yuan.spring.boot.app1.modules.commons.entity.domain;

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
public abstract class BaseDomain extends MybatisPlusDomain<Long> {
    @TableId(type = IdType.NONE)
    private Long id;
    private Long createBy;
    private Long updateBy;
    private Date createDate;
    private Date updateDate;

    public BaseDomain() {
    }

    public BaseDomain(Long id, Long createBy, Long updateBy, Date createDate, Date updateDate) {
        this.id = id;
        this.createBy = createBy;
        this.updateBy = updateBy;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }
}
