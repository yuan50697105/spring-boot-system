package com.yuan.spring.boot.test.app1.module.commons.entity.dto;

import com.yuan.spring.boot.dao.mybatis.entity.dto.MybatisQueryParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Sort;

/**
 * @author yuane
 * @date 2019/7/21 1:05
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseQueryParams extends MybatisQueryParam<Long> {

    public BaseQueryParams(Long id, Long[] ids) {
        super(id, ids);
    }

    public BaseQueryParams(Long id, Long[] ids, int pageNumber, int pageSize) {
        super(id, ids, pageNumber, pageSize);
    }

    public BaseQueryParams(Long id, Long[] ids, int pageNumber, int pageSize, Sort sort) {
        super(id, ids, pageNumber, pageSize, sort);
    }
}
