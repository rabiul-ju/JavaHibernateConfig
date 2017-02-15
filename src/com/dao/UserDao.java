package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.model.User;

public class UserDao extends HibernateConfigure{
	public Integer create(Object object) {
		Integer i=null;
		try {
			SessionFactory sessionFactory=super.hibernateConfiguration();
			Session session=null;
			Transaction transaction=null;
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			i=(Integer)session.save(object);
			transaction.commit();	
			session.clear();
			sessionFactory.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return i;
	}
	public List<User> getAllObjects() {
		SessionFactory sessionFactory=super.hibernateConfiguration();
		Session session=null;
		Transaction transaction=null;
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
		try {
			return session.createCriteria(User.class).list();
		} finally {
			// : handle finally clause
			transaction.commit();
			session.close();
		}
	}
}
