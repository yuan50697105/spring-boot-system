package com.yuan.spring.boot.dao.hibernate.entity.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.util.StringUtils;

import javax.persistence.MappedSuperclass;
import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.util.HashSet;

/**
 * @author yuane
 * @date 2019/6/15 17:03
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
public abstract class HibernateDomain<ID extends Serializable> extends com.yuan.spring.boot.dao.commons.entity.domain.BaseDomain<ID> implements Serializable {

}
