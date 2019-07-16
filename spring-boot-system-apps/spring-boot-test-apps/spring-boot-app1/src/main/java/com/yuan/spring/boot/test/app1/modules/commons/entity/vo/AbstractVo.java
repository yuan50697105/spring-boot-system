package com.yuan.spring.boot.test.app1.modules.commons.entity.vo;

import com.yuan.spring.boot.dao.mybatis.entity.vo.MybatisVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author yuane
 * @date 2019/7/17 0:41
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public abstract class AbstractVo extends MybatisVo<Long> {
    public AbstractVo() {
    }

    public AbstractVo(Long id) {
        super(id);
    }
}
