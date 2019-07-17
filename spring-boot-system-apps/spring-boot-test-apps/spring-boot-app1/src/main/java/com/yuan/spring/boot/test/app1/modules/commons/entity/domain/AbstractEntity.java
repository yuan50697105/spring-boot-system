package com.yuan.spring.boot.test.app1.modules.commons.entity.domain;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.yuan.spring.boot.dao.mybatis.entity.domain.MybatisDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @author yuane
 * @date 2019/7/17 0:38
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
public abstract class AbstractEntity extends MybatisDomain<Long> {
    @Id
    @Excel(name = "主键", isColumnHidden = true)
    private Long id;

}
