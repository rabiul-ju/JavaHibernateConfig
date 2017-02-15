package com.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConfigure {

	public SessionFactory hibernateConfiguration() {
		Configuration configuration=new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory;
		sessionFactory=configuration.buildSessionFactory();
		return sessionFactory;
	}
}