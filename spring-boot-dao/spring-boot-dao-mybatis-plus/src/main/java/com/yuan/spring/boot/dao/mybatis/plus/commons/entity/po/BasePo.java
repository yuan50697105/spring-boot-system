package com.yuan.spring.boot.dao.mybatis.plus.commons.entity.po;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
@NoArgsConstructor
@AllArgsConstructor
public abstract class BasePo<ID> implements Serializable, Cloneable {
    @TableId(type = IdType.NONE)
    private ID id;
    @TableField(fill = FieldFill.INSERT, value = "create_user")
    private String createUser;
    @TableField(fill = FieldFill.UPDATE, value = "update_user")
    private String updateUser;
    @TableField(fill = FieldFill.INSERT, value = "create_data")
    private Date createDate;
    @TableField(fill = FieldFill.UPDATE, value = "update_date")
    private Date updateDate;


    @SuppressWarnings("ToArrayCallWithZeroLengthArrayArgument")
    public BasePo<ID> copyFrom(BasePo<ID> basePo) {
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
        return this;
    }


}
