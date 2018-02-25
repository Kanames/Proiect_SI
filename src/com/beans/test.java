package com.beans;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class test {
	public static void main(String[] args) {
		T_VisitLog visitlog = new T_VisitLog();
		
		visitlog.setBrowerVersion("test");
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(T_VisitLog.class).buildSessionFactory();
		Session s = factory.getCurrentSession();
		
		s.beginTransaction();
		s.save(visitlog);
		s.getTransaction().commit();
		factory.close();
	}
}
