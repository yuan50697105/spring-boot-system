package com.yuan.spring.boot.test.app1.modules.commons.entity.dto;

import com.yuan.spring.boot.test.app1.modules.commons.entity.domain.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public abstract class AbstractQueryResult extends AbstractEntity {
    public AbstractQueryResult() {
    }

    public AbstractQueryResult(Long id) {
        super(id);
    }
}
