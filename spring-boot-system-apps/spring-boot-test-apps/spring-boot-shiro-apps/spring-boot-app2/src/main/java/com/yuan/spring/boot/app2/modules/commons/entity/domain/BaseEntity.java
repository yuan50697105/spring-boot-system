package com.yuan.spring.boot.app2.modules.commons.entity.domain;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.TableId;
import com.yuan.spring.boot.dao.mybatis.plus.entity.domain.MybatisPlusDomain;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author yuane
 * @date 2019/7/22 22:50
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class BaseEntity extends MybatisPlusDomain<Long> {
    @TableId
    @Excel(name = "主键", isColumnHidden = true)
    private Long id;
}
