package com.yuan.spring.boot.test.app1.module.commons.entity.domain;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.yuan.spring.boot.dao.mybatis.entity.domain.MybatisDomain;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Id;
import java.util.Date;

/**
 * @author yuane
 * @date 2019/7/21 0:57
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class BaseEntity extends MybatisDomain<Long> {
    @Id
    @Excel(name = "主键")
    private Long id;
    @Excel(name = "创建人")
    private String createBy;
    @Excel(name = "最后修改人")
    private String modifyBy;
    @Excel(name = "创建时间")
    private Date createDate;
    @Excel(name = "最后修改时间")
    private Date modifyDate;

}
