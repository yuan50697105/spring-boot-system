package com.yuan.springbootwebmybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yuan.spring.boot.mybatis.plus.commons.entity.po.BasePo;
import com.yuan.spring.boot.mybatis.plus.commons.mapper.BaseMapper;
import com.yuan.spring.boot.mybatis.plus.commons.service.BaseService;
import com.yuan.spring.boot.mybatis.plus.commons.service.impl.BaseServiceImpl;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootWebMybatisPlusApplicationTests {

    @Autowired
    ApplicationContext context;

    @Test
    public void contextLoads() {
    }

    @Test
    @Transactional
    @Rollback(false)
    public void testSave() {
    }

    public boolean isNotEmpty(Object object){
        return !StringUtils.isEmpty(object);
    }

    @Test
    public void test1() {
        String id="";
        String name="";
        SysUserMapper sysUserMapper = context.getBean(SysUserMapper.class);
        QueryWrapper<SysUser> sysUserQueryWrapper = new QueryWrapper<>(SysUser.builder().id(id).name(name).build());
        sysUserMapper.selectOne(sysUserQueryWrapper);
        QueryWrapper<SysUser> sysUserQueryWrapper1 = new QueryWrapper<>();
        sysUserQueryWrapper1.eq(isNotEmpty(id),"id", id);
        sysUserQueryWrapper1.eq(isNotEmpty(name),"name", name);
        sysUserQueryWrapper1.and(isNotEmpty(name),sysUserQueryWrapper2 -> sysUserQueryWrapper2.eq("name",name).or().eq("name",name));
        sysUserMapper.selectOne(sysUserQueryWrapper1);
    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    @NoArgsConstructor
    private static class SysUser extends BasePo {
        private String name;

        public SysUser(String name) {
            this.name = name;
        }

        @Builder
        public SysUser(String id, String createUser, String updateUser, Date createDate, Date updateDate, String name) {
            super(id, createUser, updateUser, createDate, updateDate);
            this.name = name;
        }
    }

    @Repository
    @Mapper
    private interface SysUserMapper extends BaseMapper<SysUser> {
    }

    private interface SysUserService extends BaseService<SysUser> {

    }

    @Service
    private class SysUserServiceImpl extends BaseServiceImpl<SysUserMapper, SysUser> implements SysUserService {

        @Override
        public void checkSave(SysUser sysUser) throws RuntimeException {

        }

        @Override
        public void checkUpdate(SysUser sysUser) throws RuntimeException {

        }

        @Override
        public void checkSaveOrUpdate(SysUser sysUser) throws RuntimeException {

        }

    }
}
