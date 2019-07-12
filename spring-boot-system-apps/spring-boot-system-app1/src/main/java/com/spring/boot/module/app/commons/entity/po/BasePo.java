package com.spring.boot.module.app.commons.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class BasePo extends com.yuan.spring.boot.dao.mybatis.plus.commons.entity.po.BasePo<String> {
    @TableId(type = IdType.UUID)
    private String id;


    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }
}
