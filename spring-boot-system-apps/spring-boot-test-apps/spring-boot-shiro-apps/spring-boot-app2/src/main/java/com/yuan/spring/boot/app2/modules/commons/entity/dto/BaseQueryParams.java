package com.yuan.spring.boot.app2.modules.commons.entity.dto;

import com.yuan.spring.boot.dao.mybatis.plus.entity.dto.MybatisPlusQueryParams;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author yuane
 * @date 2019/7/22 22:52
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class BaseQueryParams extends MybatisPlusQueryParams<Long> {
}
