package com.yuan.spring.boot.dao.mybatis.entity.vo;

import com.yuan.spring.boot.dao.commons.entity.vo.BaseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author yuane
 * @date 2019/7/13 14:53
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class MybatisVo<ID extends Serializable> extends BaseVo<ID> {
    public MybatisVo() {
    }

    public MybatisVo(ID id) {
        super(id);
    }
}
