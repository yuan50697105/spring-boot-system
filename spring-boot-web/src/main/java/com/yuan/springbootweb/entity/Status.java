package com.yuan.springbootweb.entity;

import lombok.Data;

/**
 * @author yuane
 * @date 2019/6/8 14:36
 **/
public enum Status {
    SUCCESS("success"),ERROR("error");
    private String status;

    Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
