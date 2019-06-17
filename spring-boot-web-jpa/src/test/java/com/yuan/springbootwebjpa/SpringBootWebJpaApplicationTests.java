package com.yuan.springbootwebjpa;

import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.hibernate.search.SearchQuery;
import com.yuan.springbootwebjpa.system.entity.User;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableTransactionManagement
@EnableJpaRepositories
public class SpringBootWebJpaApplicationTests {
    @Autowired
    ApplicationContext context;
    @Autowired
    private EntityManager entityManager;
    @Test
    public void contextLoads() {
    }

    @Test
    @Transactional
    public void test() {
        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
        fullTextEntityManager.createIndexer(User.class);
        FullTextSession fullTextSession = fullTextEntityManager.getSearchFactory().unwrap(FullTextSession.class);
        SearchQuery<User> searchQuery = new SearchQuery(fullTextSession, new PathBuilder(User.class, "user"));
        List<User> fetch = searchQuery.fetch();
        System.out.println(fetch);
    }

}
