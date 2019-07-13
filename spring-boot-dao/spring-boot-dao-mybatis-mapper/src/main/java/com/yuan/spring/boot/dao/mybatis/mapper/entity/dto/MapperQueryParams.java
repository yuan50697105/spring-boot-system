package com.yuan.spring.boot.dao.mybatis.mapper.entity.dto;

import com.yuan.spring.boot.dao.commons.entity.dto.BaseQueryParams;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yuane
 * @date 2019/6/21 21:15
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public abstract class MapperQueryParams<ID extends Serializable> extends BaseQueryParams<ID> implements Serializable {
    public MapperQueryParams() {
    }

    public MapperQueryParams(ID id, ID[] ids) {
        super(id, ids);
    }
}
