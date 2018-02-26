package com.Login;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.beans.T_VisitLog;

import hibernateImp.HibernateUtil;
/**
 * Clasele de tip BH sunt folosite in cadrul proiectului ca si clase pentru operarea de metode DB precum INSERT, UPDATE, DELETE.
 * @author Stefan
 * @version 0.1
 */
public class LoginBH {

	public static void saveVisitLog(T_VisitLog visitLog){
		SessionFactory sessionFactory =  new HibernateUtil().getSessionFactory();
		Session session =  sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(visitLog);
		session.getTransaction().commit();
	}
	
	
}
