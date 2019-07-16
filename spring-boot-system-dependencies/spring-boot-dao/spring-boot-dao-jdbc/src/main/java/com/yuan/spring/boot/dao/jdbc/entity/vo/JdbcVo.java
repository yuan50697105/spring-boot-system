package com.yuan.spring.boot.dao.jdbc.entity.vo;

import com.yuan.spring.boot.dao.commons.entity.vo.BaseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author yuane
 * @date 2019/7/13 22:40
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class JdbcVo<ID extends Serializable> extends BaseVo<ID> {
    public JdbcVo() {
    }

    public JdbcVo(ID id) {
        super(id);
    }
}
