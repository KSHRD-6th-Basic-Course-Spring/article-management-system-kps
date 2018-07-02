package com.kshrd.ams.configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
public class DatabaseConfiguration {

	// Kompung Som DB
	@Bean
	@Profile("kps")
	public DataSource kps() {
		DriverManagerDataSource db = new DriverManagerDataSource();
		db.setDriverClassName("org.postgresql.Driver");
		db.setUrl("jdbc:postgresql://localhost:5432/ams_kps");
		db.setUsername("postgres");
		db.setPassword("12345");
		return db;
	}
	
	// Siem Reap DB
	@Bean
	@Profile("sr")
	public DataSource sr() {
		DriverManagerDataSource db = new DriverManagerDataSource();
		db.setDriverClassName("org.postgresql.Driver");
		db.setUrl("jdbc:postgresql://localhost:5432/ams_sr");
		db.setUsername("postgres");
		db.setPassword("12345");
		return db;
	}
	
	// In memory DB
	@Bean
	@Profile("memory")
	public DataSource inMemory() {
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		builder.setType(EmbeddedDatabaseType.H2);
		builder.addScripts("sql/tables.sql", "sql/data.sql");
		return builder.build();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
