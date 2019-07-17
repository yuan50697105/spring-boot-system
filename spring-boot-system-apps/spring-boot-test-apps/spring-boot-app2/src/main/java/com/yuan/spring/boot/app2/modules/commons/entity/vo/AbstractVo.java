package com.yuan.spring.boot.app2.modules.commons.entity.vo;

import com.yuan.spring.boot.dao.mybatis.plus.entity.vo.MybatisPlusVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public abstract class AbstractVo extends MybatisPlusVo<Long> {
    public AbstractVo() {
    }

    public AbstractVo(Long id) {
        super(id);
    }
}
