package com.yuan.springbootwebenhance.commons.entity.po;

import com.gitee.hengboy.mybatis.enhance.common.annotation.Id;
import com.gitee.hengboy.mybatis.enhance.common.enums.KeyGeneratorTypeEnum;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yuane
 * @date 2019/6/15 22:21
 **/
@Data
public abstract class BasePo implements Serializable {
    @Id(generatorType = KeyGeneratorTypeEnum.UUID)
    private String id;
    private String createUser;
    private String updateUser;
    private Date createDate;
    private Date updateDate;

    public BasePo() {
    }

    public BasePo(String id, String createUser, String updateUser, Date createDate, Date updateDate) {
        this.id = id;
        this.createUser = createUser;
        this.updateUser = updateUser;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }
}
