package com.yuan.spring.boot.test.app1.module.system.dao;

import com.yuan.spring.boot.test.app1.module.commons.dao.BaseDao;
import com.yuan.spring.boot.test.app1.module.system.entity.domain.SysUser;
import com.yuan.spring.boot.test.app1.module.system.entity.validator.SaveValid;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.util.Optional;

/**
 * @author yuane
 * @date 2019/7/21 23:43
 **/
@Repository
@Mapper
public interface SysUserDao extends BaseDao<SysUser> {
    Optional<SysUser> findByUsernameEquals(@NotNull(message = "不能为空", groups = SaveValid.class) String username);
}
