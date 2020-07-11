package com.ecom.config;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.ecom.model.Authorization;
import com.ecom.model.Billing;
import com.ecom.model.Cart;
import com.ecom.model.CartItem;
/*import com.ecom.model.CartItem;*/
import com.ecom.model.Category;

import com.ecom.model.Product;
import com.ecom.model.Shipping;
import com.ecom.model.Supplier;
import com.ecom.model.User;
import com.ecom.model.UserOrder;


@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages="com.ecom")
public class HibernateConfiguration implements Filter{
	
	@Bean("dataSource")
	public DataSource getH2DataSource()
	
	{
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/20");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		return dataSource;
	
	}
	@Autowired
	@Bean("sessionFactory")
	public  SessionFactory getSessionFactory(DataSource dataSource)
	{
		LocalSessionFactoryBuilder sessionFactory=new LocalSessionFactoryBuilder(dataSource);
		
	sessionFactory.addAnnotatedClass(Category.class);
		sessionFactory.addAnnotatedClass(Product.class);
	    sessionFactory.addAnnotatedClass(Supplier.class);
	    sessionFactory.addAnnotatedClass(User.class);
	    sessionFactory.addAnnotatedClass(Authorization.class);
	    sessionFactory.addAnnotatedClass(Shipping.class);
	    sessionFactory.addAnnotatedClass(Billing.class);
	    
	   sessionFactory.addAnnotatedClass(CartItem.class);
	    sessionFactory.addAnnotatedClass(UserOrder.class);
	    
	    sessionFactory.addAnnotatedClass(Cart.class);

      sessionFactory.addProperties(getHibernateProperties());
		
		return sessionFactory.buildSessionFactory();
		
	}
	
	
	public Properties getHibernateProperties()
	{

		Properties properties=new Properties();
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("format_sql", "true");
		properties.setProperty("use_sql_comments", "true");
		properties.setProperty("hibernate.hbm2ddl.auto","update");
		return properties;
	}
	
	
	@Autowired
	@Bean
	public HibernateTransactionManager geTransactionManager(SessionFactory sessionFactory)
	{
		HibernateTransactionManager transactionManager=new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory);
		return transactionManager;
	}
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Filtering on...........................................................");
		HttpServletResponse response = (HttpServletResponse) res;
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers", "X-requested-with, Content-Type");
		chain.doFilter(req, res);

		
		
	}
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
