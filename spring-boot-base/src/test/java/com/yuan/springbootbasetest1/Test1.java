package com.yuan.springbootbasetest1;

import org.junit.Test;

import javax.activation.MimetypesFileTypeMap;

/**
 * @author yuane
 * @date 2019/6/15 14:32
 **/
public class Test1 {
    @Test
    public void test() {
        String contentType = new MimetypesFileTypeMap().getContentType(".mp4");
        System.out.println(contentType);
    }
}
