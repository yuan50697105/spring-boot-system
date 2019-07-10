package com.yuan.spring.boot.dao.mybatis.plus.commons.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.util.StringUtils;

import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;

/**
 * @author yuane
 * @date 2019/6/15 23:28
 **/
@Data
public abstract class BasePo<ID> implements Serializable, Cloneable {
    @TableId(type = IdType.NONE)
    private ID id;
    private String createUser;
    private String updateUser;
    private Date createDate;
    private Date updateDate;

    public BasePo() {
    }

    public BasePo(ID id, String createUser, String updateUser, Date createDate, Date updateDate) {
        this.id = id;
        this.createUser = createUser;
        this.updateUser = updateUser;
        this.createDate = createDate;
        this.updateDate = updateDate;
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
