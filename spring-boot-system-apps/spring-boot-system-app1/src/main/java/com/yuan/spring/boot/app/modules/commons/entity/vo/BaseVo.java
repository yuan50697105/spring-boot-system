package com.yuan.spring.boot.app.modules.commons.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author yuane
 * @date 2019/7/13 11:55
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseVo extends com.yuan.spring.boot.dao.mybatis.plus.commons.entity.vo.BaseVo<String> {
}
