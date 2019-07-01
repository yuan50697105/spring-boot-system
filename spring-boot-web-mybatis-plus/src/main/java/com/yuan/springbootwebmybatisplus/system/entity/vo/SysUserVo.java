package com.yuan.springbootwebmybatisplus.system.entity.vo;

import com.yuan.springbootwebmybatisplus.commons.entity.vo.BaseVo;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author yuane
 * @date 2019/7/1 22:32
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class SysUserVo extends BaseVo {
    private String username;
    private String password;
    private String name;
    private String nameSpellFull;
    private String nameSpellSimple;
    private Integer enabled;

    public SysUserVo(String username, String password, String name, String nameSpellFull, String nameSpellSimple, Integer enabled) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.nameSpellFull = nameSpellFull;
        this.nameSpellSimple = nameSpellSimple;
        this.enabled = enabled;
    }

    @Builder
    public SysUserVo(String id, String createUser, String updateUser, Date createDate, Date updateDate, String username, String password, String name, String nameSpellFull, String nameSpellSimple, Integer enabled) {
        super(id, createUser, updateUser, createDate, updateDate);
        this.username = username;
        this.password = password;
        this.name = name;
        this.nameSpellFull = nameSpellFull;
        this.nameSpellSimple = nameSpellSimple;
        this.enabled = enabled;
    }
}
