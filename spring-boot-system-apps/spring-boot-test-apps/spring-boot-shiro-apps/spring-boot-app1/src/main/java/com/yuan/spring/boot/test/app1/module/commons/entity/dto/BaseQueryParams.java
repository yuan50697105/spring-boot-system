package com.yuan.spring.boot.test.app1.module.commons.entity.dto;

import com.yuan.spring.boot.dao.mybatis.entity.dto.MybatisQueryParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author yuane
 * @date 2019/7/21 1:05
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseQueryParams extends MybatisQueryParam<Long> {

    private String createBy;
    private String modifyBy;
    private Date createDateStart;
    private Date createDateEne;
    private Date modifyDateStart;
    private Date modifyDateEnd;

}
