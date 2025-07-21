package com.yoy.crudoperation.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.yoy.crudoperation.Entity.Student;

@EnableTransactionManagement
@Configuration
public class HbrntConfig 
{
//	1. CREATE A BEAN FOR DATASOURCE
	@Bean
	DataSource dMDataSource() {
		DriverManagerDataSource dmds = new DriverManagerDataSource() ;
		dmds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dmds.setUrl("jdbc:mysql://127.0.0.1:3306/sb_hbrnt");
		dmds.setUsername("root") ;
		dmds.setPassword("ABCxyz123@") ;
		return dmds ;	}
	
//	2. CREATE BEAN FOR SESSION FACTORY
	@Bean
	LocalSessionFactoryBean sessionFactory() {
		
		LocalSessionFactoryBean lsfb = new LocalSessionFactoryBean() ;
		lsfb.setDataSource(dMDataSource());
		
		Properties properties = new Properties() ;
		properties.setProperty("hibernate.hbm2ddl.auto", "update") ;
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect") ;
		properties.setProperty("hibernate.show_sql", "true") ;
		properties.setProperty("hibernate.formate_sql", "true") ;
		
		lsfb.setHibernateProperties(properties);
//		lsfb.setPackagesToScan("com.yoy.crudoperation.Entity"); // for object-table mapping information
		lsfb.setAnnotatedClasses(Student.class); // for object-table mapping information
		
		return lsfb ;	}
	
//	3. ENABLE TRANSACTION MANAGEMENT -- ALREADY DONE AT FIRST
	
//	4. CREATE A BEAN FOR TRASACTION MANAGER
	@Bean
	HibernateTransactionManager transactionManager() {
		HibernateTransactionManager htm = new HibernateTransactionManager();
		htm.setSessionFactory(sessionFactory().getObject());
		return htm ;	}	
	
//	HibernateTemplate use krne par compatibility issue aa rhe the because newer version usko support nahi kr rhe
}
