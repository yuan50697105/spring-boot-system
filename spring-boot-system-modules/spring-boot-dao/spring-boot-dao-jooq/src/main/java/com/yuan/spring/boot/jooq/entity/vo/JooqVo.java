package com.yuan.spring.boot.jooq.entity.vo;

import com.yuan.spring.boot.dao.commons.entity.vo.BaseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author yuane
 * @date 2019/7/18 22:13
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public abstract class JooqVo<ID extends Serializable> extends BaseVo<ID> {
    public JooqVo() {
    }

    public JooqVo(ID id) {
        super(id);
    }
}
