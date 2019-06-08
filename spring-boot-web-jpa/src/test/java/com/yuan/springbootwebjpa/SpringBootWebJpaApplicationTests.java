package com.yuan.springbootwebjpa;

import com.yuan.springbootwebjpa.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableTransactionManagement
@EnableJpaRepositories
public class SpringBootWebJpaApplicationTests {
    @Autowired
    ApplicationContext context;
    @Test
    public void contextLoads() {
    }

    @Test
    @Transactional()
    @Rollback(false)
    public void testSave(){
        EntityManager bean = context.getBean(EntityManager.class);
        User user = new User();
        user.setName("aaaa");
        User merge = bean.merge(user);
        bean.flush();
        System.out.println(merge);
    }

    @Test
    @Transactional
    public void  testSelect(){
        EntityManager bean = context.getBean(EntityManager.class);
        TypedQuery<User> select_u_from_user_u = bean.createQuery("select u from User u", User.class);
        System.out.println(select_u_from_user_u.getResultList());
    }


    @Test
    public void testSelect2(){
        EntityManager bean = context.getBean(EntityManager.class);
        Query nativeQuery = bean.createNativeQuery("select * from user", User.class);
        System.out.println(nativeQuery.getResultList());
    }

    @Test
    public void testSelect3(){
        EntityManager bean = context.getBean(EntityManager.class);
        StoredProcedureQuery selectUser = bean.createStoredProcedureQuery("selectUser", User.class);
        System.out.println(selectUser.getResultList());
    }

}
