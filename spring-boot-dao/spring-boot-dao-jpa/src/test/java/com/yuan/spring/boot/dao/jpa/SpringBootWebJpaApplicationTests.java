package com.yuan.spring.boot.dao.jpa;

import com.github.wenhao.jpa.PredicateBuilder;
import com.github.wenhao.jpa.Specifications;
import com.yuan.spring.boot.dao.jpa.commons.dao.BaseDao;
import com.yuan.spring.boot.dao.jpa.commons.dao.impl.BaseDaoImpl;
import com.yuan.spring.boot.dao.jpa.commons.entity.dto.ArrayQuery;
import com.yuan.spring.boot.dao.jpa.commons.entity.dto.MapQuery;
import com.yuan.spring.boot.dao.jpa.commons.entity.po.BasePo;
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
@EnableJpaRepositories(repositoryBaseClass = BaseDaoImpl.class)
public class SpringBootWebJpaApplicationTests {
    @Autowired
    ApplicationContext context;

    @Test
    public void contextLoads() {
    }
}