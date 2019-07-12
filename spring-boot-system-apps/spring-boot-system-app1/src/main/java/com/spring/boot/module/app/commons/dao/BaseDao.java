package com.spring.boot.module.app.commons.dao;


import com.spring.boot.module.app.commons.entity.po.BasePo;

public interface BaseDao<T extends BasePo> extends com.yuan.spring.boot.dao.mybatis.plus.commons.dao.BaseDao<T, String> {
}
