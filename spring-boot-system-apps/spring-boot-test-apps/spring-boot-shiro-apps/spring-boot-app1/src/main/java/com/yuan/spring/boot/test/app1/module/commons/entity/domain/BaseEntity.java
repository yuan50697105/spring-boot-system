package com.yuan.spring.boot.test.app1.module.commons.entity.domain;

import com.yuan.spring.boot.dao.mybatis.entity.domain.MybatisDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.mybatis.annotation.Condition;
import org.springframework.data.mybatis.annotation.CreatedBy;
import org.springframework.data.mybatis.annotation.CreatedDate;

import javax.persistence.Id;
import java.util.Date;

/**
 * @author yuane
 * @date 2019/7/21 0:57
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity extends MybatisDomain<Long> {
    @Id
    @Condition
    private Long id;
    @CreatedDate
    private Date createDate;
    //    @LastModifiedDate
    private Date modifyDate;
    @CreatedBy
    private Long createBy;
    //    @LastModifiedBy
    private Long modifyBy;


}
