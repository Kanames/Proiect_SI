package com.Login;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.beans.T_VisitLog;

import hibernateImp.HibernateUtil;

public class LoginBH {


	public static void saveVisitLog(T_VisitLog visitLog){
		SessionFactory sessionFactory =  new HibernateUtil().getSessionFactory();
		Session session =  sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(visitLog);
		session.getTransaction().commit();

	}
	
}
