package com.yuan.springbootchinese2pinyin.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author yuane
 * @date 2019/6/29 12:26
 **/
@Aspect
@Component
@Slf4j
public aspect SpellAspect {
    private String name;

    @Pointcut(value = "annotation(com.yuan.springbootchinese2pinyin.annotation.Name)")
    public void nameAspect() {
    }

    @Pointcut(value = "annotation(com.yuan.springbootchinese2pinyin.annotation.NameSpellFull)")
    public void nameSpellFullAspect() {
    }

    @Pointcut(value = "annotation(com.yuan.springbootchinese2pinyin.annotation.NameSpellSimple)")
    public void nameSpellSimpleAsepect() {
    }


    @Before(value = "nameAspect()", argNames = "joinPoint")
    public void nameDoBefore(JoinPoint joinPoint) {
        System.out.println("执行 name before");
    }

    @Around("nameAspect()")
    public Object arountName(ProceedingJoinPoint joinPoint) {
        System.out.println("环绕 name around");
        return new Object();
    }

    @After("nameAspect()")
    public void afterName(JoinPoint joinPoint) {
        System.out.println("结束 name after");
    }
}
