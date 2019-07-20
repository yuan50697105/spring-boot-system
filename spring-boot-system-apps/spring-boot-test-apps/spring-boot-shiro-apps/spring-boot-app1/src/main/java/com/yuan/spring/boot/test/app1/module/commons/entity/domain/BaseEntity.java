package com.yuan.spring.boot.test.app1.module.commons.entity.domain;

import com.yuan.spring.boot.dao.mybatis.entity.domain.MybatisDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

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
    private Long id;


}
