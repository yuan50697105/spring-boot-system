package com.yuan.spring.boot.test.app1.module.system.dao;

import com.yuan.spring.boot.test.app1.module.commons.dao.BaseDao;
import com.yuan.spring.boot.test.app1.module.system.entity.domain.SysUser;
import com.yuan.spring.boot.test.app1.module.system.entity.validator.SaveValid;
import com.yuan.spring.boot.test.app1.module.system.entity.validator.UpdateValid;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mybatis.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.concurrent.ListenableFuture;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author yuane
 * @date 2019/7/21 23:43
 **/
@Repository
@Mapper
public interface SysUserDao extends BaseDao<SysUser> {

    @Query
    List<SysUser> findAllByNameContains(@NotNull(message = "不能为空", groups = {SaveValid.class, UpdateValid.class}) @Param("name") String name);

    @Query
    ListenableFuture<SysUser> findAllByUsernameContaining(String username);

    Page<SysUser> findAllByUsernameContainingAndNameContaining(Pageable pageable, String username, String name);

    @Query
    Page<SysUser> findAllByParams(Pageable pageable);

    @Query
    Long findCountByParams();
}
