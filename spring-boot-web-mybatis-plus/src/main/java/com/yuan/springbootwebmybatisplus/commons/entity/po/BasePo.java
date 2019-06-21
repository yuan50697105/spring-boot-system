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
    @TableId(type = IdType.AUTO)
    private Long id;
    private String createUser;
    private String updateUser;
    private Date createDate;
    private Date updateDate;
}
