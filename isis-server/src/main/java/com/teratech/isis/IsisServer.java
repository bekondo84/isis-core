package com.teratech.isis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.hibernate.autoconfigure.HibernateJpaAutoConfiguration;
import org.springframework.boot.jdbc.autoconfigure.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@SpringBootApplication(scanBasePackages = "com.teratech",
exclude = {DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class IsisServer {

	public static void main(String[] args) {
		SpringApplication.run(IsisServer.class, args);
	}

}
