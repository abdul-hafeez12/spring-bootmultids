package com.ahafeez.multids.database;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


@Configuration()
public class DataSourceConfiguration {

	@Bean
	@Primary
	@ConfigurationProperties("spring.datasource1")
	DataSourceProperties cpuDataSourceProperties() {
		return new DataSourceProperties();
	}

    @Bean
    @Primary
    DataSource dataSource1(DataSourceProperties dpa) {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(dpa.getDriverClassName());
		dataSource.setUrl(dpa.getUrl());
		dataSource.setUsername(dpa.getUsername());
		dataSource.setPassword(dpa.getPassword());
		return dataSource;
	}

    @Bean
    @Primary
    JdbcClient jdbcClient1(@Qualifier("dataSource1") DataSource dataSource) {
    	return JdbcClient.create(dataSource);
    }


    @Bean
    @ConfigurationProperties("spring.datasource2")
    DataSourceProperties secondDataSourceProperties() {
        return new DataSourceProperties();
    }
    
    @Bean
    DataSource dataSource2(@Qualifier("secondDataSourceProperties") DataSourceProperties dpa) {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(dpa.getDriverClassName());
		dataSource.setUrl(dpa.getUrl());
		dataSource.setUsername(dpa.getUsername());
		dataSource.setPassword(dpa.getPassword());
		return dataSource;
	}

    @Bean
    @Primary
    JdbcClient jdbcClient2(@Qualifier("dataSource2") DataSource dataSource) {
    	return JdbcClient.create(dataSource);
    }


}