package com.yuan.springbootwebjpa.utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;

import java.io.Serializable;
import java.util.Properties;

/**
 * @author yuane
 * @date 2019/6/8 15:21
 **/
public class MyIdentifierGenerator implements IdentifierGenerator, Configurable {
    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        return IdUtils.generateId();
    }

    @Override
    public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) throws MappingException {

    }
}
