package com.yuan.spring.boot.dao.jpa.commons.entity.po;

import com.sun.xml.internal.bind.v2.model.core.ID;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.util.StringUtils;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;

/**
 * @author yuane
 * @date 2019/6/15 17:03
 **/
@Data
@MappedSuperclass
public abstract class BasePo<T> implements Serializable {
    @Id
    private ID id;
    private Date createDate;
    private Date updateDate;
    private String createUser;
    private String updateUser;

    public BasePo() {
    }

    public BasePo(ID id, Date createDate, Date updateDate, String createUser, String updateUser) {
        this.id = id;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.createUser = createUser;
        this.updateUser = updateUser;
    }

    @SuppressWarnings("ToArrayCallWithZeroLengthArrayArgument")
    public void copyFrom(BasePo basePo) {
        BeanWrapperImpl beanWrapper = new BeanWrapperImpl(basePo);
        PropertyDescriptor[] propertyDescriptors = beanWrapper.getPropertyDescriptors();
        HashSet<String> set = new HashSet<>(propertyDescriptors.length);
        for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
            String name = propertyDescriptor.getName();
            Object value = beanWrapper.getPropertyValue(name);
            if (StringUtils.isEmpty(value)) {
                set.add(name);
            }
        }
        BeanUtils.copyProperties(basePo, this, set.toArray(new String[set.size()]));
    }

}
