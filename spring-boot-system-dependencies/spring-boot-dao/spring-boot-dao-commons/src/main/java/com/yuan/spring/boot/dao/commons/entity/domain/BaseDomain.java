package com.yuan.spring.boot.dao.commons.entity.domain;

import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.util.StringUtils;

import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

@Data
public abstract class BaseDomain<ID extends Serializable> {

    public abstract ID getId();

    public abstract void setId(ID id);

    public BaseDomain() {
    }


    @SuppressWarnings({"ToArrayCallWithZeroLengthArrayArgument", "Duplicates"})
    public BaseDomain<ID> copyFrom(BaseDomain<ID> baseDomain) {
        BeanWrapperImpl beanWrapper = new BeanWrapperImpl(baseDomain);
        PropertyDescriptor[] propertyDescriptors = beanWrapper.getPropertyDescriptors();
        HashSet<String> set = new HashSet<>(propertyDescriptors.length);
        for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
            String name = propertyDescriptor.getName();
            Object value = beanWrapper.getPropertyValue(name);
            if (StringUtils.isEmpty(value)) {
                set.add(name);
            }
        }
        BeanUtils.copyProperties(baseDomain, this, set.toArray(new String[set.size()]));
        return this;
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
