package com.yuan.springbootwebjdbc.entity;

import lombok.Data;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

/**
 * @author yuane
 * @date 2019/6/8 17:34
 **/
@Data
public class User {
    private String id;
    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
}
