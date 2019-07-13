package com.yuan.spring.boot.dao.mybatis.plus.commons.entity.po;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.util.StringUtils;

import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author yuane
 * @date 2019/6/15 23:28
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseDomain<ID> implements Serializable, Cloneable {
    @TableField(value = "create_user", fill = FieldFill.INSERT)
    private ID createUser;
    @TableField(value = "update_user", fill = FieldFill.UPDATE)
    private ID updateUser;
    @TableField(value = "create_date", fill = FieldFill.INSERT)
    private Date createDate;
    @TableField(value = "update_date", fill = FieldFill.UPDATE)
    private Date updateDate;

    public abstract ID getId();

    public abstract void setId(ID id);

    @SuppressWarnings("ToArrayCallWithZeroLengthArrayArgument")
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
            if (!StringUtils.isEmpty(value)) {
                map.put(name, value);
            }
        }
        return map;
    }


}
