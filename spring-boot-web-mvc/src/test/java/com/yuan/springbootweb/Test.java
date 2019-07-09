package com.yuan.springbootweb;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yuan.spring.boot.web.mvc.entity.dto.Result;
import com.yuan.spring.boot.web.mvc.entity.vo.AjaxResult;

/**
 * @author yuane
 * @date 2019/7/6 12:06
 **/
public class Test {
    @org.junit.Test
    public void name() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        AjaxResult result = Result.Status.SUCCESS.withMessage("成功").toAjax();
        System.out.println(objectMapper.writeValueAsString(result));
        AjaxResult result1 = Result.message(Result.Status.SUCCESS, "成功").toAjax();
        System.out.println(objectMapper.writeValueAsString(result1));

    }
}
