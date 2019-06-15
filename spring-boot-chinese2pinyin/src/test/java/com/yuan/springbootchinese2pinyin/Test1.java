package com.yuan.springbootchinese2pinyin;

import com.yuan.springbootchinese2pinyin.utils.SpellUtils;
import org.junit.Test;

import static java.lang.String.format;

/**
 * @author yuane
 * @date 2019/6/15 11:40
 **/
public class Test1 {
    @Test
    public void test() {
        String testCode = "原恩泽";
        String spell = SpellUtils.getSpell(testCode);
        String fireSpell = SpellUtils.getFireSpell(testCode);
        System.out.println(format("中文名称:%s，全拼:%s，简拼:%s", testCode, spell, fireSpell));
    }
}
