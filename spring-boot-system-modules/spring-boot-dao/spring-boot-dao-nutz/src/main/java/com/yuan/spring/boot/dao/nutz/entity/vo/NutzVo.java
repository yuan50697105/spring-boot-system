package com.yuan.spring.boot.dao.nutz.entity.vo;

import com.yuan.spring.boot.dao.commons.entity.vo.BaseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author yuane
 * @date 2019/7/17 23:50
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class NutzVo<ID extends Serializable> extends BaseVo<ID> {
    public NutzVo() {
    }

    public NutzVo(ID id) {
        super(id);
    }
}
