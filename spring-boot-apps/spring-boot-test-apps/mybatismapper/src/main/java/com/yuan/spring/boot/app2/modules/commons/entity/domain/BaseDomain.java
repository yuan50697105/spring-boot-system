package com.yuan.spring.boot.app2.modules.commons.entity.domain;

import com.yuan.spring.boot.dao.mybatis.mapper.entity.domain.MapperDomain;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * @author yuane
 * @date 2019/7/16 0:46
 **/
@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
@Data
public abstract class BaseDomain extends MapperDomain<String> {
    private String id;
    private String createBy;
    private String updateBy;
    private Date createDate;
    private Date updateDate;

    public BaseDomain() {
    }


    public BaseDomain(String id, String createBy, String updateBy, Date createDate, Date updateDate) {
        super(id);
        this.id = id;
        this.createBy = createBy;
        this.updateBy = updateBy;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }
}
