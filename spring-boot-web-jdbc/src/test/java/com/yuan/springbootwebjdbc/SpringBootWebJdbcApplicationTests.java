package com.yuan.springbootwebjdbc;

import com.xphsc.easyjdbc.page.PageInfo;
import com.yuan.springbootwebjdbc.commons.dao.BaseDao;
import com.yuan.springbootwebjdbc.commons.dao.impl.BaseDaoImpl;
import com.yuan.springbootwebjdbc.commons.entity.BaseEntity;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootWebJdbcApplicationTests {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Autowired
    private ApplicationContext context;

    @Test
    public void contextLoads() {
    }

    @Test
    public void test() {

    }

    public interface SysUserDao extends BaseDao<SysUser> {
        PageInfo<Map<String, Object>> findPage(SysUser sysUser);
    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    @Entity
    @Table(name = "sys_user")
    @NoArgsConstructor
    public static class SysUser extends BaseEntity {
        private String username;
        private String name;
        private String nameSpellFull;
        private String nameSpellSimple;
        private Integer enabled;


        public SysUser(String username, String name, String nameSpellFull, String nameSpellSimple, Integer enabled) {
            this.username = username;
            this.name = name;
            this.nameSpellFull = nameSpellFull;
            this.nameSpellSimple = nameSpellSimple;
            this.enabled = enabled;
        }

        @Builder
        public SysUser(String id, String createBy, String updateBy, Date createDate, Date updateDate, String username, String name, String nameSpellFull, String nameSpellSimple, Integer enabled) {
            super(id, createBy, updateBy, createDate, updateDate);
            this.username = username;
            this.name = name;
            this.nameSpellFull = nameSpellFull;
            this.nameSpellSimple = nameSpellSimple;
            this.enabled = enabled;
        }
    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    public static class SysUserQueryParams extends SysUser {

    }

    @Repository
    public static class SysUserDaoImpl extends BaseDaoImpl<SysUser> implements SysUserDao {

        public SysUserDaoImpl() {
            super(jdbcTemplate, namedParameterJdbcTemplate);
        }

        @Override
        public PageInfo<Map<String, Object>> findPage(SysUser sysUser) {
            StringBuilder stringBuilder = new StringBuilder();
            return getEasyJdbcTemplate().findByPage(stringBuilder.toString(), Map.class, 1, 1);
        }
    }
}
