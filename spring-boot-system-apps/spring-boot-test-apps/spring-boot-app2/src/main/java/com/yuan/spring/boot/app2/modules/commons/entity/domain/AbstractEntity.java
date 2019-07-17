package com.yuan.spring.boot.app2.modules.commons.entity.domain;

import com.yuan.spring.boot.dao.mybatis.plus.entity.domain.MybatisPlusDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class AbstractEntity extends MybatisPlusDomain<Long> {
    private Long id;

}
