package com.yuan.springbootwebjpa.commons.entity.po;

import com.yuan.springbootutils.utils.IdUtils;
import lombok.Data;
import org.hibernate.search.annotations.DocumentId;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * @author yuane
 * @date 2019/6/15 17:03
 **/
@Data
@MappedSuperclass
public class BasePo implements Serializable {
    @Id
    @DocumentId
    private String id = IdUtils.getTimeId(20);
}
