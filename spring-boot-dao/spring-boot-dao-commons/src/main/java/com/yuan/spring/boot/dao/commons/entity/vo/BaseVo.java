package com.yuan.spring.boot.dao.commons.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author yuane
 * @date 2019/7/13 12:05
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseVo<ID extends Serializable> {
    private ID id;

}
