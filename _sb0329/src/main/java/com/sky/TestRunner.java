package com.sky;

import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class TestRunner implements ApplicationRunner {

	@Autowired
	DataSource dataSource;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Connection connection = dataSource.getConnection();
		log.info("DBCP: " + dataSource.getClass());
		log.info("Url: " + connection.getMetaData());
		log.info("UserName: " + connection.getMetaData().getUserName());

		jdbcTemplate.execute("insert into products (prod_name, prod_price) values('버킷햇1', 6900)");
		jdbcTemplate.execute("insert into products (prod_name, prod_price) values('버킷햇2', 7900)");
		jdbcTemplate.execute("insert into products (prod_name, prod_price) values('버킷햇3', 8900)");
		jdbcTemplate.execute("insert into member (name,city, street,zipcode ) values('홍길동', '서울', '강남구','123-456')");
	}

}
