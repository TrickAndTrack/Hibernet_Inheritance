package com.app.utility;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.app.entity.Coustmer;
import com.app.entity.Foods;


public class utility {
	public static SessionFactory getConnection() {
		
		Properties properties= new Properties();
		properties.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
		properties.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/pass_person");
		properties.setProperty("hibernate.connection.username", "root");
		properties.setProperty("hibernate.connection.password", "root");
		properties.setProperty("hibernate.connection.dialect", "org.hibernate.dialect.MySQL5Dialect");
		
		Configuration cfg = new Configuration();
		cfg.setProperties(properties);
		cfg.addAnnotatedClass(Coustmer.class);
		cfg.addAnnotatedClass(Foods.class);
		
		
	    StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
		builder.applySettings(cfg.getProperties());

		StandardServiceRegistry serviceRegistry = builder.build();

		return cfg.buildSessionFactory(serviceRegistry); 	
		}
}
