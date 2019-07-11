package com.yuan.spring.boot.dao.mybatis.plus.commons.entity.bo;

import lombok.Data;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yuane
 * @date 2019/6/20 22:56
 **/
@Data
public abstract class BaseQueryParams<ID> implements Serializable {
    private ID id;
    private ID[] ids;
    private String createUser;
    private String updateUser;
    private Date createDate;
    private Date updateDate;
    private Date createDateStart;
    private Date createDateEnd;
    private Date updateDateStart;
    private Date updateDateEnd;

    public BaseQueryParams() {
    }

    public BaseQueryParams(ID id, ID[] ids, String createUser, String updateUser, Date createDate, Date updateDate, Date createDateStart, Date createDateEnd, Date updateDateStart, Date updateDateEnd) {
        this.id = id;
        this.ids = ids;
        this.createUser = createUser;
        this.updateUser = updateUser;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.createDateStart = createDateStart;
        this.createDateEnd = createDateEnd;
        this.updateDateStart = updateDateStart;
        this.updateDateEnd = updateDateEnd;
    }

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
