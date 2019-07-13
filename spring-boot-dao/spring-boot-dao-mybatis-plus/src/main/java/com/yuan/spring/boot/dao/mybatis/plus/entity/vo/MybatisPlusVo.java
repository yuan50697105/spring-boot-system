package com.yuan.spring.boot.dao.mybatis.plus.entity.vo;

import com.yuan.spring.boot.dao.commons.entity.vo.BaseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author yuane
 * @date 2019/7/13 11:53
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public abstract class MybatisPlusVo<ID extends Serializable> extends BaseVo<ID> implements Serializable {
    public MybatisPlusVo() {
    }

    public MybatisPlusVo(ID id) {
        super(id);
    }
}
