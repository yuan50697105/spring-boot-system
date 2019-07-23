package com.yuan.spring.boot.app2.modules.system.entity.domain;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yuan.spring.boot.app2.modules.commons.entity.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

/**
 * @author yuane
 * @date 2019/7/22 22:56
 **/
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Data
@TableName("sys_user")
public class SysUser extends BaseEntity {
    @Excel(name = "用户名")
    @NotNull
    @Range(max = 100)
    private String username;
    @Excel(name = "密码", isColumnHidden = true)
    @NotNull
    @Range(max = 100)
    private String password;
    @Excel(name = "姓名")
    @NotNull
    @Range(max = 50)
    private String name;
    @Excel(name = "姓名全拼")
    private String nameSpellFull;
    @Excel(name = "姓名简拼")
    private String nameSpellSimple;
    private Integer enabled;

}
