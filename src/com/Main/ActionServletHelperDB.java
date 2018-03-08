package com.Main;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.beans.T_Chat;
import com.beans.T_Message;

import hibernateImp.HibernateUtil;

public class ActionServletHelperDB {
	static final Logger log = Logger.getLogger(ActionServletHelperDB.class);
	public static void saveMessage(String mesajScris, String numeUser) {
		log.debug("<<< In saveMessage >>>");
		T_Chat mesaj = new T_Chat();
		mesaj.setText(mesajScris);
		mesaj.setUsername(numeUser);
		Session session =  new HibernateUtil().getSession();
		session.beginTransaction();
		Serializable id = session.save(mesaj);
		System.out.println("############# id -> "+id.toString());
		session.getTransaction().commit();
		log.debug("<<< OUT saveMessage >>>");
	}

	public static List selectMessages(Date date, String numeUser) {
		log.debug("<<< In selectMessages >>>");
		SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Session session =  new HibernateUtil().getSession();
		session.beginTransaction();
		String hql2 = "FROM T_Chat WHERE Time  >= '"+sdf.format(date)+"' AND username not like '"+numeUser+"'";
		System.out.println(hql2);
		Query mesajeDB = session.createQuery(hql2);
		List mesaje = mesajeDB.getResultList();
		log.debug("<<< OUT selectMessages >>>");
		session.getTransaction().commit();
		return mesaje;
	}
}
