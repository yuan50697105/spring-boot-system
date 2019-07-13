package com.yuan.spring.boot.dao.mybatis.enhance.entity.domain;

import com.yuan.spring.boot.dao.commons.entity.domain.BaseDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class EnhanceDomain<ID extends Serializable> extends BaseDomain<ID> {
}
