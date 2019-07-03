package com.yuan.springbootwebmapper.commons.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author yuane
 * @date 2019/7/1 22:31
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseVo {
    private String id;
    private String createUser;
    private String updateUser;
    private Date createDate = new Date();
    private Date updateDate = new Date();

}
