package com.yuan.springbootwebmybatisplus.commons.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yuane
 * @date 2019/6/15 23:28
 **/
@Data
public abstract class BasePo implements Serializable {
    @TableId(type = IdType.UUID)
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
