package com.yuan.springbootwebjpa.commons.entity.bo;

import lombok.Data;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yuane
 * @date 2019/6/20 19:23
 **/
@Data
public abstract class BaseQueryParam implements Serializable {
    private String id;
    private String[] ids;
    private Iterable<String> iterable;
    private String createUser;
    private String updateUser;
    private Date createDate;
    private Date createDateStart;
    private Date createDateEnd;
    private Date updateDate;
    private Date updateDateStart;
    private Date updateDateEnd;

    public BaseQueryParam() {
    }

    public BaseQueryParam(String id, String[] ids, Iterable<String> iterable, String createUser, String updateUser, Date createDate, Date createDateStart, Date createDateEnd, Date updateDate, Date updateDateStart, Date updateDateEnd) {
        this.id = id;
        this.ids = ids;
        this.iterable = iterable;
        this.createUser = createUser;
        this.updateUser = updateUser;
        this.createDate = createDate;
        this.createDateStart = createDateStart;
        this.createDateEnd = createDateEnd;
        this.updateDate = updateDate;
        this.updateDateStart = updateDateStart;
        this.updateDateEnd = updateDateEnd;
    }

    public Map<String, Object> toParamsMap() {
        Map<String, Object> map = new HashMap<>();
        BeanWrapperImpl beanWrapper = new BeanWrapperImpl(this);
        PropertyDescriptor[] propertyDescriptors = beanWrapper.getPropertyDescriptors();
        for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
            String name = propertyDescriptor.getName();
            Object value = beanWrapper.getPropertyValue(name);
            map.put(name, value);
        }
        return map;
    }

}
