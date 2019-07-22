package com.yuan.spring.boot.app2.modules.commons.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuane
 * @date 2019/7/22 22:55
 **/
@ControllerAdvice
@RestController
public abstract class BaseController extends com.yuan.spring.web.mvc.controller.BaseController {
}
