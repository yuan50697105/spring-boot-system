package com.yuan.spring.web.mvc.controller;

import com.yuan.spring.web.mvc.annotation.ViewPrefix;
import com.yuan.spring.web.mvc.entity.dto.DtoResult;
import com.yuan.spring.web.mvc.entity.vo.AjaxResult;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@ControllerAdvice
public class BaseController {
    private String prefix;

    public BaseController() {
        ViewPrefix annotation = AnnotationUtils.findAnnotation(this.getClass(), ViewPrefix.class);
        if (annotation != null) {
            String value = annotation.value();
            if (value.length() > 0) {
                if (value.endsWith("/")) {
                    prefix = value;
                } else {
                    prefix = value + "/";
                }
            } else {
                prefix = value;
            }
        } else {
            prefix = "";
        }
    }

    @ExceptionHandler(Exception.class)
    public AjaxResult handler(Exception e) {
        return DtoResult.error(e.getMessage()).convert();
    }

    protected String display(String view) {
        return prefix + view;
    }


    protected ModelAndView displayModelAndView(String view) {
        return new ModelAndView(display(view));
    }

    protected ModelAndView displayModelAndView(String view, Map<String, ?> model) {
        return new ModelAndView(display(view), model);
    }
}
