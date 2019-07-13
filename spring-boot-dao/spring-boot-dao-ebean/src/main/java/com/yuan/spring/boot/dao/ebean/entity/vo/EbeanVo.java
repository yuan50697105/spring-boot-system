package com.yuan.spring.boot.dao.ebean.entity.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author yuane
 * @date 2019/7/13 12:23
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class EbeanVo<ID extends Serializable> extends com.yuan.spring.boot.dao.commons.entity.vo.BaseVo<ID> {
    public EbeanVo() {

    }

    public EbeanVo(ID id) {
        super(id);
    }
}
