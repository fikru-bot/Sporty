package io.ecommerce.galery.config;

import java.beans.PropertyVetoException;
import java.util.Properties;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import io.ecommerce.galery.util.DataUtility;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan("io.ecommerce.galery")
@PropertySource({"classpath:persistence-mysql.properties", "classpath:persistence-validation.properties"})
public class GaleryConfiguration implements WebMvcConfigurer {
	
	private Logger log = Logger.getLogger(getClass().getName());
	
	@Autowired
	private Environment env;
	
	@Bean
	public DataSource getHibDataSourse() {
		log.info("getting the hibernate dtata sources");
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		try {
			cpds.setDriverClass("com.mysql.cj.jdbc.Driver");
			cpds.setJdbcUrl(env.getProperty("jdbc.url"));
			cpds.setUser(env.getProperty("jdbc.user"));
			cpds.setPassword(env.getProperty("jdbc.password"));
			cpds.setInitialPoolSize(DataUtility.getInt(env.getProperty("connection.pool.initialPoolSize")));
			cpds.setMinPoolSize(DataUtility.getInt(env.getProperty("connection.pool.minPoolSize")));
			cpds.setMaxPoolSize(DataUtility.getInt(env.getProperty("connection.pool.maxPoolSize")));
			cpds.setMaxIdleTime(DataUtility.getInt(env.getProperty("connection.pool.maxIdleTime")));
		} catch (PropertyVetoException e) {
			e.printStackTrace();
			throw new ApplicationContextException("Exception in GetHibDataSourse " + e.getMessage());
		}
		log.info("GetHibDataSourse method end");
		return cpds;
	}
	private Properties getHibernateProperties() {
		log.info("getHibernatePropertirs method start");

		Properties prop = new Properties();
		prop.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
		prop.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		prop.setProperty("hibernate.hbm2ddl.auto",env.getProperty("hibernate.hbm2ddl.auto"));
		log.info("getHibernateProperies method end");
		return prop;
	}
	
	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		log.info("getSessionFactory method start");

		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(getHibDataSourse());
		sessionFactory.setHibernateProperties(getHibernateProperties());
		sessionFactory.setPackagesToScan(env.getProperty("hibernate.packagesToScan"));

		log.info("getSessionFactory method end");
		return sessionFactory;
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		log.info("transactionManager method start");

		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);

		log.info("transactionManager method end");
		return txManager;
	}
	
	@Bean
	public ViewResolver viewResolver() {
		log.info("viewResolver method start");
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		log.info("viewResolver method start");
		return viewResolver;
	}
	
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Bean
	public MultipartResolver multipartResolver() {
		return new CommonsMultipartResolver();
	}

}













