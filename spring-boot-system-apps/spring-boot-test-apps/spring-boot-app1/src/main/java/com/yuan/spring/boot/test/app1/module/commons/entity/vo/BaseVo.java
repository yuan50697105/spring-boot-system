package com.yuan.spring.boot.test.app1.module.commons.entity.vo;

import com.yuan.spring.boot.test.app1.module.commons.entity.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author yuane
 * @date 2019/7/21 1:05
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseVo extends BaseEntity {
    public BaseVo(Long id) {
        super(id);
    }
}
