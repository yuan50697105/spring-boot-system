package com.yuan.spring.boot.dao.mybatis.enhance.entity.vo;

import com.yuan.spring.boot.dao.commons.entity.vo.BaseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author yuane
 * @date 2019/7/13 15:00
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class MybatisEnhanceVo<ID extends Serializable> extends BaseVo<ID> {
    public MybatisEnhanceVo() {
    }

    public MybatisEnhanceVo(ID id) {
        super(id);
    }
}
