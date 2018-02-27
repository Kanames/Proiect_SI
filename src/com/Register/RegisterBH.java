package com.Register;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.beans.T_Profile;
import com.beans.T_User;
import com.beans.T_VisitLog;

import hibernateImp.HibernateUtil;

/**
 * Clasele de tip BH sunt folosite in cadrul proiectului ca si clase pentru operarea de metode DB precum INSERT, UPDATE, DELETE.
 * @author Stefan
 * @version 0.1
 */
public class RegisterBH {
	static final Logger log = Logger.getLogger(RegisterBH.class);
	public static void saveUser(T_User user){
		log.debug("<<<< IN saveUser() >>>>"); 
		SessionFactory sessionFactory =  new HibernateUtil().getSessionFactory();
		Session session =  sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		log.debug("<<<< OUT saveUser() >>>>"); 
	}
	public static void saveProfilUser(T_Profile profil){
		log.debug("<<<< IN saveProfilUser() >>>>"); 
		SessionFactory sessionFactory =  new HibernateUtil().getSessionFactory();
		Session session =  sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(profil);
		session.getTransaction().commit();
		log.debug("<<<< IN saveProfilUser() >>>>"); 
	}

}
