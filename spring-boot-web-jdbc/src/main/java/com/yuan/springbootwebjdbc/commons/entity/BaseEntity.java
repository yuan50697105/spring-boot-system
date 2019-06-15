package com.yuan.springbootwebjdbc.commons.entity;

import com.yuan.springbootutils.utils.IdUtils;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * @author yuane
 * @date 2019/6/15 16:26
 **/
@MappedSuperclass
@Data
public class BaseEntity implements Serializable {
    @Id
    private String id = IdUtils.getTimeId(20);
}
