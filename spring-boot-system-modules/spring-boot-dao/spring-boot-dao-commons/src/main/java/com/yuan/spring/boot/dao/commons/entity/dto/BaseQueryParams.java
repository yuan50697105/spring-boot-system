package com.yuan.spring.boot.dao.commons.entity.dto;

import lombok.Data;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yuane
 * @date 2019/6/20 19:23
 **/
@Data
public abstract class BaseQueryParams<ID extends Serializable> implements Serializable {
    private ID id;
    private ID[] ids;

    public BaseQueryParams() {
    }

    public BaseQueryParams(ID id, ID[] ids) {
        this.id = id;
        this.ids = ids;
    }


    @SuppressWarnings("Duplicates")
    public Map<String, Object> toParamsMap() {

        BeanWrapperImpl beanWrapper = new BeanWrapperImpl(this);
        PropertyDescriptor[] propertyDescriptors = beanWrapper.getPropertyDescriptors();
        Map<String, Object> map = new HashMap<>(propertyDescriptors.length);
        for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
            String name = propertyDescriptor.getName();
            Object value = beanWrapper.getPropertyValue(name);
            map.put(name, value);
        }
        return map;
    }

}
