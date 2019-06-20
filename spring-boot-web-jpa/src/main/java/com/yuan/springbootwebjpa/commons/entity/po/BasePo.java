package com.yuan.springbootwebjpa.commons.entity.po;

import lombok.Data;
import org.hibernate.search.annotations.DocumentId;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author yuane
 * @date 2019/6/15 17:03
 **/
@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BasePo implements Serializable {
    @Id
    @DocumentId
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @CreatedDate
    private Date createDate;
    @LastModifiedDate
    private Date updateDate;
    @CreatedBy
    private String createUser;
    @LastModifiedBy
    private String updateUser;
}
