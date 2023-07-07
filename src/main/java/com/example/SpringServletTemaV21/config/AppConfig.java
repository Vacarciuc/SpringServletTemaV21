package com.example.SpringServletTemaV21.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

public class AppConfig {
    @Bean
    public JdbcTemplate jdbcTemplate(HikariDataSource hikariDataSource){
        return new JdbcTemplate(hikariDataSource);
    }
}
