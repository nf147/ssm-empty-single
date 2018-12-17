package com.nf147.ssms.configuration.root;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import javax.transaction.TransactionManager;

@Configuration
public class MybatisConfig {
    @Value("jdbc.user")
    private String user;

    @Bean
    DataSource dataSource() {
        return null;
    }

    @Bean
    SqlSessionFactoryBean sqlSessionFactoryBean() {
        return null;
    }

    @Bean
    MapperScannerConfigurer mapperScannerConfigurer() {
        return null;
    }

    @Bean
    TransactionManager transactionManager() {
        return null;
    }
}
