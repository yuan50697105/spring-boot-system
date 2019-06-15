package com.yuan.springbootwebenhance.commons.entity;

import com.yuan.springbootutils.utils.IdUtils;
import lombok.Data;

import java.io.Serializable;

/**
 * @author yuane
 * @date 2019/6/15 22:21
 **/
@Data
public class BaseEntity implements Serializable {
    private String id = IdUtils.getTimeId(20);
}
