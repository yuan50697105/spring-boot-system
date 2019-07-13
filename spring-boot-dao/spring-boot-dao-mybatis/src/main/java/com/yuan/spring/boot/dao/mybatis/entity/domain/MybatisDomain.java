package com.yuan.spring.boot.dao.mybatis.entity.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

/**
 * @author yuane
 * @date 2019/7/10 22:33
 **/
@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class MybatisDomain<ID extends Serializable> extends com.yuan.spring.boot.dao.commons.entity.domain.BaseDomain<ID>  {
}
