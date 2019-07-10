package com.yuan.spring.boot.dao.jpa;

import com.github.wenhao.jpa.PredicateBuilder;
import com.github.wenhao.jpa.Specifications;
import com.yuan.spring.boot.dao.jpa.commons.entity.dto.ArrayQuery;
import com.yuan.spring.boot.dao.jpa.commons.entity.dto.MapQuery;
import com.yuan.spring.boot.dao.jpa.commons.entity.po.BasePo;
import com.yuan.spring.boot.dao.jpa.commons.repository.BaseRepository;
import com.yuan.spring.boot.dao.jpa.commons.repository.impl.BaseRepositoryImpl;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jooq.impl.DSL;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.util.StringUtils;

import javax.persistence.Entity;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableTransactionManagement
@EnableJpaRepositories(repositoryBaseClass = BaseRepositoryImpl.class)
public class SpringBootWebJpaApplicationTests {
    @Autowired
    ApplicationContext context;

    @Test
    public void contextLoads() {
    }

    public boolean isNotEmpty(Object object) {
        return !StringUtils.isEmpty(object);
    }

    public void test() {


        SysUserDao sysUserDao = context.getBean(SysUserDao.class);

        /*单条*/
        Optional<SysUser> user1 = sysUserDao.findByIdAndUsername("", "aaa");
        Optional<SysUser> user2 = sysUserDao.findOne(Example.of(SysUser.builder().id("").username("aaa").build()));
        Optional<SysUser> user3 = sysUserDao.findOne(Specifications.<SysUser>and().eq("id", "").eq("username", "aaa").build());
        Optional<SysUser> user4 = sysUserDao.findOne(DSL.selectFrom(DSL.table("sys_user")).where(DSL.field("id").eq(""), DSL.field("username").eq("aaaa")).getQuery());
        Optional<SysUser> user5 = sysUserDao.findOneBySQLQuery(ArrayQuery.of("select * from sys_user where id=? and username = ?", "", "aaa"));
        Optional<SysUser> user6 = sysUserDao.findOneByQuery(ArrayQuery.of("from SysUser u where u.id = ? and u.username = ?", "", "aaa"));
        /*列表*/
        List<SysUser> userList1 = sysUserDao.findAllByIdAndUsername("", "aaa");
        List<SysUser> userList2 = sysUserDao.findAll(Example.of(SysUser.builder().id("").username("aaa").build()));
        List<SysUser> userList3 = sysUserDao.findAll(Specifications.<SysUser>and().eq("id", "").eq("username", "aaa").build());
        List<SysUser> userList4 = sysUserDao.findAll(DSL.selectFrom(DSL.table("sys_user")).where(DSL.field("id").eq("")).and(DSL.field("username").eq("aaa")).getQuery());
        List<SysUser> userList5 = sysUserDao.findAllBySQLQuery(ArrayQuery.of("select * from sys_user where id=? and username = ?", "", "aaa"));
        List<SysUser> userList6 = sysUserDao.findAllByQuery(ArrayQuery.of("from SysUser u where u.id = ? and u.username = ?", "", "aaa"));
        /*分页*/
        PageRequest request = PageRequest.of(0, 1);
        Page<SysUser> userPage1 = sysUserDao.findAllByIdAndUsername("", "aaa", request);
        Page<SysUser> userPage2 = sysUserDao.findAll(Example.of(SysUser.builder().id("").username("aaa").build()), request);
        Page<SysUser> userPage3 = sysUserDao.findAll(Specifications.<SysUser>and().eq("id", "").eq("username", "aaa").build(), request);
        Page<SysUser> userPage4 = sysUserDao.findAll(DSL.selectFrom(DSL.table("sys_user")).where(DSL.field("id").eq("")).and(DSL.field("username").eq("aaa")).getQuery(), request);
        Page<SysUser> userPage5 = sysUserDao.findAllBySQLQuery(ArrayQuery.of("select * from sys_user where id=? and username = ?", "", "aaa"), request);
        Page<SysUser> userPage6 = sysUserDao.findAllByQuery(ArrayQuery.of("from SysUser u where u.id = ? and u.username = ?", "", "aaa"), request);
    }

    @Test
    public void test3() {
        SysUserDao sysUserDao = context.getBean(SysUserDao.class);
        List<SysUser> users = sysUserDao.findAll();
        List<SysUser> users1 = sysUserDao.findAll(Specifications.<SysUser>and().build());
        List<SysUser> users2 = sysUserDao.findAll(DSL.selectFrom(DSL.table("sys_user")).getQuery());
        List<SysUser> users3 = sysUserDao.findAllByQuery(ArrayQuery.of("from SysUser"));
        List<SysUser> users4 = sysUserDao.findAllByQuery(MapQuery.of("from SysUser", new HashMap<>()));
        List<SysUser> users5 = sysUserDao.findAllBySQLQuery(ArrayQuery.of("select * from sys_user"));
        List<SysUser> users6 = sysUserDao.findAllBySQLQuery(MapQuery.of("select * from sys_user", new HashMap<>()));


    }

    @Test
    public void test2() {
        String id = "";
        String name = "";
        PredicateBuilder<SysUser> predicateBuilder = Specifications.and();
        predicateBuilder.eq(isNotEmpty(id), "id", id);
        predicateBuilder.eq(isNotEmpty(name), "name", name);
        predicateBuilder.predicate(isNotEmpty(name), Specifications.<SysUser>or().like("name", name).like("name", name).build());

    }

    @EqualsAndHashCode(callSuper = true)
    @Entity
    @Data
    @NoArgsConstructor
    public static class SysUser extends BasePo {
        private String name;
        private String nameSpellFull;
        private String nameSpellSimple;
        private String username;
        private String password;

        public SysUser(String name, String nameSpellFull, String nameSpellSimple, String username, String password) {
            this.name = name;
            this.nameSpellFull = nameSpellFull;
            this.nameSpellSimple = nameSpellSimple;
            this.username = username;
            this.password = password;
        }

        @Builder
        public SysUser(String id, Date createDate, Date updateDate, String createUser, String updateUser, String name, String nameSpellFull, String nameSpellSimple, String username, String password) {
            super(id, createDate, updateDate, createUser, updateUser);
            this.name = name;
            this.nameSpellFull = nameSpellFull;
            this.nameSpellSimple = nameSpellSimple;
            this.username = username;
            this.password = password;
        }
    }

    @Repository
    public interface SysUserDao extends BaseRepository<SysUser, String> {
        Optional<SysUser> findByIdAndUsername(String id, String username);

        List<SysUser> findAllByIdAndUsername(String id, String username);

        Page<SysUser> findAllByIdAndUsername(String id, String username, Pageable pageable);

        Optional<SysUser> findByIdContainingAndUsernameContaining(String id, String username);

        List<SysUser> findAllByIdContainingAndUsernameContainingOrderBycOrderByCreateDateDesc(String id, String username);

        Page<SysUser> findAllByIdContainingAndUsernameContainingOrderByCreateDateDesc(String id, String username, Pageable pageable);


    }


}
