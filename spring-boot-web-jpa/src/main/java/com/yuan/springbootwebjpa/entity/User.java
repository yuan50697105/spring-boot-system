package com.yuan.springbootwebjpa.entity;

import lombok.Data;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.search.annotations.Analyzer;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

import javax.persistence.*;

/**
 * @author yuane
 * @date 2019/6/8 15:23
 **/
@Entity
@Cacheable
@Indexed(index = "user")
@Analyzer(impl = SmartChineseAnalyzer.class)
@Table(name = "user")
@Data
public class User {
    @Id
    @DocumentId
    @GeneratedValue(generator = "idGenerator")
    @GenericGenerator(name = "idGenerator", strategy = "com.yuan.springbootwebjpa.utils.MyIdentifierGenerator")
    @Column(name = "id")
    private String id;
    @Field
    @Column(name = "name")
    private String name;
}
