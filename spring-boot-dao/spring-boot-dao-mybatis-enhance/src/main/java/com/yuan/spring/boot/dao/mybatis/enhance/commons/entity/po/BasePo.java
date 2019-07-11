package com.yuan.spring.boot.dao.mybatis.enhance.commons.entity.po;

import com.gitee.hengboy.mybatis.enhance.common.annotation.Id;
import com.gitee.hengboy.mybatis.enhance.common.enums.KeyGeneratorTypeEnum;
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

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class BasePo<ID> implements Serializable {
    @Id(generatorType = KeyGeneratorTypeEnum.DIY)
    private ID id;
    private String createUser;
    private String updateUser;
    private Date createDate;
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
