package com.yuan.spring.boot.test.app1.modules.commons.entity.domain;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.TableId;
import com.yuan.spring.boot.dao.mybatis.plus.entity.domain.MybatisPlusDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author yuane
 * @date 2019/7/17 0:38
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class AbstractEntity extends MybatisPlusDomain<Long> {
    @TableId
    @Excel(name = "主键", isColumnHidden = true)
    private Long id;

}
