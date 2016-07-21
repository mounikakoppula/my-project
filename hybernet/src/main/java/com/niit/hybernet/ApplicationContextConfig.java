package com.niit.hybernet;

import java.util.Properties;


import javax.sql.DataSource;

import org.h2.engine.Database;
import org.h2.engine.Session;
import org.hibernate.SessionFactory;

import org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionCreator;
import org.hibernate.engine.spi.SessionBuilderImplementor;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.AbstractDriverBasedDataSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.orm.hibernate3.LocalSessionFactoryBean;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.dao.CategoryDAO;
import com.niit.dao.CategoryDAOImpl;
import com.niit.model.Category;
import com.niit.model.Supplier;
@Configuration
@ComponentScan("com.niit")
@EnableTransactionManagement
public class ApplicationContextConfig {
	private static final String Org = null;

	@Bean(name="datasource")
	public DataSource getH2DataSource(){
		DriverManagerDataSource datasource=new DriverManagerDataSource();
		datasource.setDriverClassName("org.h2.Driver");
		datasource.setUrl("jdbc:h2:/test");
		AbstractDriverBasedDataSource dataSorce = null;
		dataSorce.setUsername("sa");
		datasource.setPassword("sa");
		return datasource;
	}
	private Properties getHibernateProperties(){
		Properties properties=new Properties();
		properties.put("hibernate.show_sql","true");
		Object hibernate;
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		return properties;
		
		
	}
	
	@Autowired
	@Bean(name="sessionFactory")
	
	public SessionFactory getSessionFactory(Database datasource){
		DataSource dataSource = null;
		LocalSessionFactoryBuilder SessionBuilder=new LocalSessionFactoryBuilder(dataSource);
		SessionBuilder.addProperties(getHibernateProperties());
		SessionBuilder.addAnnotatedClass(Category.class);
		SessionBuilder.addAnnotatedClass(Supplier.class);
		return SessionBuilder.buildSessionFactory();
	}

		
		@Autowired
		@Bean(name="transactionManager")
		public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory){
			HibernateTransactionManager transactionManager= new HibernateTransactionManager(sessionFactory);
			return transactionManager;
		}


        @Autowired
        @Bean(name= "categoryDAO")
        public CategoryDAO   getCategoryDAO(SessionFactory sessionFactory){
         return new CategoryDAOImpl(sessionFactory);
        }
}


        
      
		


