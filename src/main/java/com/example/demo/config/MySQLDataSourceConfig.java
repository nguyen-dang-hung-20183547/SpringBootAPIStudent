package com.example.demo.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Configuration
public class MySQLDataSourceConfig implements DataSourceConfig{
    @Bean
    public DataSource getDataSource(){
        System.out.println("Config DataSoure");
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url("jdbc:mysql://localhost/micro_db");
        dataSourceBuilder.username("root");
        dataSourceBuilder.password("buianhvan");
        return dataSourceBuilder.build();
    }
}
