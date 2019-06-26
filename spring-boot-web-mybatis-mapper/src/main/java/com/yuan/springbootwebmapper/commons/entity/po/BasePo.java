package com.yuan.springbootwebmapper.commons.entity.po;

import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.genid.GenId;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.UUID;

/**
 * @author yuane
 * @date 2019/6/15 22:47
 **/
@Data
@MappedSuperclass
public abstract class BasePo implements Serializable, GenId<String> {
    @Id
    @KeySql(genId = BasePo.class)
    private String id;
    private String createUser;
    private String updateUser;
    private Date createDate;
    private Date updateDate;

    @Override
    public String genId(String table, String column) {
        return UUID.randomUUID().toString();
    }

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
