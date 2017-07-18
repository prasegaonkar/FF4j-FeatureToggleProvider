package edu.mywork;

import javax.sql.DataSource;

import org.ff4j.FF4j;
import org.ff4j.cache.InMemoryCacheManager;
import org.ff4j.store.JdbcFeatureStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FF4JConfiguration {

	@Autowired
	private DataSource dataSource;

	@Bean
	public FF4j getFF4j() {

		FF4j ff4j = new FF4j();
		ff4j.setFeatureStore(new JdbcFeatureStore(dataSource));
		ff4j.cache(new InMemoryCacheManager());

		return ff4j;
	}
}