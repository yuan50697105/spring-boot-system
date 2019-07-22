package com.yuan.spring.boot.app2.modules.commons.entity.vo;

import com.yuan.spring.boot.dao.mybatis.plus.entity.vo.MybatisPlusVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author yuane
 * @date 2019/7/22 22:58
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class BaseVo extends MybatisPlusVo<Long> {
}
