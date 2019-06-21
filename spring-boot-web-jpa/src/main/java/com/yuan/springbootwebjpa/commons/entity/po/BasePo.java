package com.yuan.springbootwebjpa.commons.entity.po;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.search.annotations.DocumentId;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

/**
 * @author yuane
 * @date 2019/6/15 17:03
 **/
@Data
@MappedSuperclass
public abstract class BasePo implements Serializable {
    @Id
    @DocumentId
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(strategy = "uuid2", name = "uuid2 ")
    private String id;
    private Date createDate;
    private Date updateDate;
    private String createUser;
    private String updateUser;

    public BasePo() {
    }

    public BasePo(String id, Date createDate, Date updateDate, String createUser, String updateUser) {
        this.id = id;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.createUser = createUser;
        this.updateUser = updateUser;
    }

}
