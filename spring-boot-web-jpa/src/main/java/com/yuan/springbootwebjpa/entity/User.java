package com.yuan.springbootwebjpa.entity;

import com.yuan.springbootwebjpa.commons.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.hibernate.search.annotations.Analyzer;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author yuane
 * @date 2019/6/8 15:23
 **/
@EqualsAndHashCode(callSuper = true)
@Entity
@Cacheable
@Indexed(index = "user")
@Analyzer(impl = SmartChineseAnalyzer.class)
@Table(name = "user")
@Data
@ToString(callSuper = true)
public class User extends BaseEntity {
    //    @Id
//    @DocumentId
//    @GeneratedValue(generator = "idGenerator")
//    @GenericGenerator(name = "idGenerator", strategy = "com.yuan.springbootwebjpa.utils.MyIdentifierGenerator")
//    @Column(name = "id")
//    private String id;
    @Field
    @Column(name = "name")
    private String name;
}
