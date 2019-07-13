package com.yuan.spring.boot.dao.mybatis.mapper.entity.vo;

import com.yuan.spring.boot.dao.commons.entity.vo.BaseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author yuane
 * @date 2019/7/13 21:02
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class MapperVo<ID extends Serializable> extends BaseVo<ID> {
    public MapperVo() {
    }

    public MapperVo(ID id) {
        super(id);
    }
}
