package com.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.model.Login;

public class LoginDao extends HibernateConfigure{
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
	public Object getObjetByMobile(String number) {
		Configuration configuration=new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		SessionFactory sessionFactory;
		sessionFactory=configuration.buildSessionFactory();
		
		Session session=null;
		Transaction transaction=null;
		String qString=null;
		 qString="FROM Login U WHERE U.mobileNumber='"+number+"'";
		session = sessionFactory.openSession();

		transaction = session.beginTransaction();
		try {
			Login login=new Login();
			login=null;	
			Query q = session.createQuery(qString);
			login=(Login)q.uniqueResult();
			return login;
		} finally {
			transaction.commit();
			session.close();
		}
	}	
}
