package com.spring.boot.module.app.commons.service;

import com.spring.boot.module.app.commons.entity.po.BasePo;

public interface BaseService<T extends BasePo> extends com.yuan.spring.boot.dao.mybatis.plus.commons.service.BaseService<T, String> {
}
