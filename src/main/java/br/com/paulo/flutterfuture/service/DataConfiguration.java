package br.com.paulo.flutterfuture.service;


import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "flutterEntityManagerFactory",
        transactionManagerRef = "flutterTransactionManager",
        basePackages = { "br.com.paulo.flutterfuture.repository" }
)
public class DataConfiguration {

	
	@Bean(name = "MySqlDataSource")
    public DataSource dataSource() {
        return DataSourceBuilder.create()
        		.driverClassName("com.mysql.cj.jdbc.Driver")
        		.url("jdbc:mysql://localhost:3306/flutter?useTimezone=true&serverTimezone=UTC")
        		.username("root")
        		.password("")
        		.build();
    }
    
   
    @Bean(name = "flutterEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean
    entityManagerFactory(EntityManagerFactoryBuilder builder,@Qualifier("MySqlDataSource") DataSource dataSource ) {
    	Map<String, String> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", "create-drop");
        properties.put("hibernate.id.new_generator_mappings","false");

    	
        return builder
                .dataSource(dataSource)
                .packages("br.com.paulo.flutterfuture.entity")
                .persistenceUnit("MySql")
                .properties(properties)
                .build();
    }

   
    @Bean(name = "flutterTransactionManager")
    public PlatformTransactionManager transactionManager(@Qualifier("flutterEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}

